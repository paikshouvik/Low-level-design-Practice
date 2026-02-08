package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {
    private final Map<String, Topic> topics = new ConcurrentHashMap<>();

    public void createTopic(String name) {
        topics.putIfAbsent(name, new Topic(name, 4));
    }

    public void publish(String topic, Message msg) {
        if(!topics.containsKey(topic)) throw new RuntimeException("Topic not found");
        topics.get(topic).publish(msg);
    }

    public void subscribe(String topic, ISubscriber sub, String groupId) {
        if(!topics.containsKey(topic)) throw new RuntimeException("Topic not found");
        topics.get(topic).addSubscriber(sub, groupId);
    }
}