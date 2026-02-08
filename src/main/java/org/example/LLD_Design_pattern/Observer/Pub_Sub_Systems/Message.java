package org.example.LLD_Design_pattern.Observer.Pub_Sub_Systems;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class Message {
    private final String messageId;

    private final String payload;
    private final Instant timestamp;
    private long offset; // Assigned by the Topic

    public Message(String payload) {
        this.messageId = UUID.randomUUID().toString();
        this.payload = payload;
        this.timestamp = Instant.now();
    }

    @Override
    public String toString() {
        return "Msg[id=" + messageId + ", off=" + offset + ", payload=" + payload + "]";
    }
}