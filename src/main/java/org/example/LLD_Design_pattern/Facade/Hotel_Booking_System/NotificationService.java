package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

class NotificationService {
    public void sendConfirmation(String email) {
        System.out.println("Booking confirmation sent to: " + email);
    }
}
