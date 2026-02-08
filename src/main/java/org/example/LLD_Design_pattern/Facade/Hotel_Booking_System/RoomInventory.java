package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

class RoomInventory {
    public boolean isAvailable(String roomType) {
        System.out.println("Checking availability for: " + roomType);
        return true; 
    }
}

