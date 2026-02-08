package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

public class ShippingService implements ISubscriber {
    private final String id;

    public ShippingService(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) {
        System.out.println("[ShippingService " + id + "] Processing labels for: " + message.getPayload());
    }
}
