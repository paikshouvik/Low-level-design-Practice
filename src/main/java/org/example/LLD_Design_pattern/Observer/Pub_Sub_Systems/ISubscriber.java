package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}