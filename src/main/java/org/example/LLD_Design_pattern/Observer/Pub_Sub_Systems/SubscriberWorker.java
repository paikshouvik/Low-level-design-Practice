package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class SubscriberWorker {
    private final ISubscriber sub;
    private final AtomicInteger offset; // The offset this specific worker is at

    public SubscriberWorker(ISubscriber sub) {
        this.sub = sub;
        this.offset = new AtomicInteger(0);
    }

}
