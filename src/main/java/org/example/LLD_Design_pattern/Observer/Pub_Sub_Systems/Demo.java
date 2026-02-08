package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

public class Demo {
    public static void main(String[] args) {
        MessageBroker broker = new MessageBroker();
        broker.createTopic("orders");

        // Create concrete instances
        ISubscriber auditLog = new AuditService("AUDIT_001");
        ISubscriber shippingWest = new ShippingService("SHIP_WEST_01");
        ISubscriber shippingEast = new ShippingService("SHIP_EAST_01");

        // Subscribe using the concrete objects
        broker.subscribe("orders", auditLog, "AuditGroup");
        
        // These two belong to the same group, so they will share the load
        broker.subscribe("orders", shippingWest, "ShippingGroup");
        broker.subscribe("orders", shippingEast, "ShippingGroup");

        broker.publish("orders", new Message("Laptop"));
        broker.publish("orders", new Message("Smartphone"));
    }
}