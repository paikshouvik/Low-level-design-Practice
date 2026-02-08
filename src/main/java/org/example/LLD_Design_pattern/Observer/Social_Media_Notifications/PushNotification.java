package org.example.LLD_Design_pattern.Observer.Social_Media_Notifications;

class PushNotification implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("[PUSH] To " + recipient + ": " + message);
    }
}

