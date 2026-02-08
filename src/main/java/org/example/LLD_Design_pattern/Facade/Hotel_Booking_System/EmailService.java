package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

class EmailService {
    public void sendEmail(String recipient, String message) {
        System.out.println("[Email] Sending to " + recipient + ": " + message);
    }
}
