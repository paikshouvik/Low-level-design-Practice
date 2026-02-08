package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

class PaymentProcessor {
    public boolean processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
        return true;
    }
}
