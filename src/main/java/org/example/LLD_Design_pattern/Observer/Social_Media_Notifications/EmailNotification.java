package org.example.LLD_Design_pattern.Observer.Social_Media_Notifications;

class EmailNotification implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("[EMAIL] To " + recipient + ": " + message);
    }
}
