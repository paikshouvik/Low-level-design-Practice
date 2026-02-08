package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Topic {
    private final String topicName;
    
    // The "Log" - In-memory storage (Replace with Disk I/O for persistence)
    private final List<Message> messageLog; 
    
    // Map: GroupID -> List of Subscriber Workers
    private final Map<String, List<SubscriberWorker>> subscriberGroups;
    
    private final AtomicLong offsetCounter; 
    private final ExecutorService deliveryService; // For async delivery

    public Topic(String topicName, int threadPoolSize) {
        this.topicName = topicName;
        this.messageLog = Collections.synchronizedList(new ArrayList<>());
        this.subscriberGroups = new ConcurrentHashMap<>();
        this.offsetCounter = new AtomicLong(0);
        this.deliveryService = Executors.newFixedThreadPool(threadPoolSize);
    }

    // 1. Thread-safe Publishing
    public void publish(Message message) {
        synchronized (this) { // Critical section: strict ordering
            message.setOffset(offsetCounter.getAndIncrement());
            messageLog.add(message);
        }
        // Async trigger to avoid blocking the publisher
        deliveryService.submit(this::notifySubscribers);
    }

    // 2. Register Subscriber
    public void addSubscriber(ISubscriber subscriber, String groupId) {
        // If no group provided, treat as a unique group (Fan-out behavior)
        final String targetGroup = (groupId == null || groupId.isEmpty()) 
                                   ? UUID.randomUUID().toString() 
                                   : groupId;
                                   
        SubscriberWorker worker = new SubscriberWorker(subscriber);
        
        subscriberGroups.computeIfAbsent(targetGroup, k -> new CopyOnWriteArrayList<>())
                        .add(worker);
    }
    
    // 3. Distribution Logic
    private void notifySubscribers() {
        // Iterate over every CONSUMER GROUP
        for (Map.Entry<String, List<SubscriberWorker>> entry : subscriberGroups.entrySet()) {
            List<SubscriberWorker> workers = entry.getValue();
            if (workers.isEmpty()) continue;

            // Determine global offset for this group (Simulating Kafka's Group Coordinator)
            // In this simple in-memory version, we check the 'min' offset processed by the group
            // to see what needs to be sent next.
            
            // NOTE: For simplicity, we just push NEW messages. 
            // A real persistent queue would track 'lastCommittedOffset' per group.
            int logSize = messageLog.size();
            
            // Distribute work: 
            // If Group A has 2 workers, we load balance messages between them.
            for (int i = 0; i < logSize; i++) {
                Message msg = messageLog.get(i);
                
                // Simple Round-Robin Load Balancing within the group
                int workerIndex = i % workers.size();
                SubscriberWorker worker = workers.get(workerIndex);
                
                // Only send if this worker hasn't processed it yet
                if (worker.getOffset().get() <= i) {
                    try {
                        worker.getSub().consume(msg);
                        worker.getOffset().set(i + 1); // Move offset forward
                    } catch (Exception e) {
                        System.err.println("Delivery failed for " + worker.getSub().getId());
                    }
                }
            }
        }
    }
}

