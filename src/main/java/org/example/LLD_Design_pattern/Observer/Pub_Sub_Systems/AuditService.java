package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

// Implementation A: Logging every message to a database/console
public class AuditService implements ISubscriber {
    private final String id;

    public AuditService(String id) { this.id = id; }

    @Override
    public String getId() { return id; }

    @Override
    public void consume(Message message) {
        System.out.println("[AuditService " + id + "] Archiving: " + message.getPayload());
    }
}

