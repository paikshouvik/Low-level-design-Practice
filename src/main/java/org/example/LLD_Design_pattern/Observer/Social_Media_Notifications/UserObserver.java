package org.example.LLD_Design_pattern.Observer.Social_Media_Notifications;

// Wrapper for the Observer to link a User to their preferred notification method
class UserObserver {
    private String name;
    private NotificationService preferredChannel;

    public UserObserver(String name, NotificationService channel) {
        this.name = name;
        this.preferredChannel = channel;
    }

    public void update(String message) {
        preferredChannel.send(message, name);
    }
}
