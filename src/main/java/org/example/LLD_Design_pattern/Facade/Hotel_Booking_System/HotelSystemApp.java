package org.example.LLD_Design_pattern.Facade.Hotel_Booking_System;

public class HotelSystemApp {
    public static void main(String[] args) {
        // Initialize the Facade
        HotelBookingFacade hotelApi = new HotelBookingFacade();

        // Scenario A: Successful Booking
        hotelApi.bookStay("alice@example.com", "Deluxe Suite", 299.99);

        // Scenario B: Room Unavailable
        hotelApi.bookStay("bob@example.com", "Penthouse", 1500.00);
    }
}