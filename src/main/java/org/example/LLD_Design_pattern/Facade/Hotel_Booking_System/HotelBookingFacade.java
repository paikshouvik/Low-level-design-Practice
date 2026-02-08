package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

class HotelBookingFacade {
    private InventorySystem inventory = new InventorySystem();
    private PaymentGateway payment = new PaymentGateway();
    private EmailService emailer = new EmailService();

    /**
     * The simplified interface for the client.
     */
    public void bookStay(String guestEmail, String roomType, double price) {
        System.out.println("\n--- Initiating Booking for " + guestEmail + " ---");

        // Step 1: Check Inventory
        if (!inventory.checkAvailability(roomType)) {
            emailer.sendEmail(guestEmail, "Booking Failed: Room type " + roomType + " is unavailable.");
            return;
        }

        // Step 2: Process Payment
        boolean paymentSuccess = payment.chargeCard(price);

        // Step 3: Confirm and Notify
        if (paymentSuccess) {
            String receipt = "Confirmed! Your " + roomType + " is ready.";
            emailer.sendEmail(guestEmail, receipt);
            System.out.println("--- Booking Complete! ---");
        } else {
            System.out.println("--- Booking Aborted: Payment Failed ---");
        }
    }
}