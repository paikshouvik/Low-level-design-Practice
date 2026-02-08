package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

class InventorySystem {
    public boolean checkAvailability(String roomType) {
        // Logic: All rooms are available except "Penthouse" (for demonstration)
        if (roomType.equalsIgnoreCase("Penthouse")) {
            System.out.println("[Inventory] Sorry, Penthouse is fully booked.");
            return false;
        }
        System.out.println("[Inventory] " + roomType + " is available.");
        return true;
    }
}

