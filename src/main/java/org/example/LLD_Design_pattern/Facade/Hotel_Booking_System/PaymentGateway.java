package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

class PaymentGateway {
    public boolean chargeCard(double amount) {
        if (amount <= 0) return false;
        System.out.println("[Payment] Successfully charged $" + amount + " to the card.");
        return true;
    }
}
