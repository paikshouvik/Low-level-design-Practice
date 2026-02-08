package org.example.LLD_Design_pattern.State.Order_Tracking;

import java.util.Arrays;

/**
 * Driver class to demonstrate the Flipkart Order Flow using State Pattern.
 */
public class FlipkartOrderDriver {

    public static void main(String[] args) {
        System.out.println("--- 📦 INITIATING FLIPKART ORDER SYSTEM ---");

        // 1. Create a new Order (Initially in CREATED state)
        Order order = new Order("ORD-12345", Arrays.asList("MacBook M3", "Laptop Stand"));
        printStatus(order);

        // 2. Try an illegal transition (Shipping before payment)
        try {
            System.out.println("\n> Attempting to ship without payment...");
            order.ship();
        } catch (IllegalStateException e) {
            System.err.println("BLOCKED: " + e.getMessage());
        }

        // 3. Confirm Payment (Transition: CREATED -> CONFIRMED)
        System.out.println("\n> Processing Payment...");
        order.confirmPayment();
        printStatus(order);

        // 4. Ship Order (Transition: CONFIRMED -> SHIPPED)
        System.out.println("\n> Handing over to Logistics (Ecom Express)...");
        order.ship();
        printStatus(order);

        // 5. Try to cancel after shipping
        System.out.println("\n> User clicks 'Cancel Order' while in transit...");
        order.cancel(); 

        // 6. Deliver Order (Transition: SHIPPED -> DELIVERED)
        System.out.println("\n> Delivery Partner confirms delivery...");
        order.deliver();
        printStatus(order);

        // 7. Final Terminal State Check
        System.out.println("\n> Final check: Can we ship it again?");
        try {
            order.ship();
        } catch (IllegalStateException e) {
            System.err.println("BLOCKED: " + e.getMessage());
        }

        System.out.println("\n--- ✅ ORDER LIFECYCLE COMPLETE ---");
    }

    private static void printStatus(Order order) {
        System.out.println("CURRENT ORDER STATUS: [" + order.getStatus() + "]");
    }
}