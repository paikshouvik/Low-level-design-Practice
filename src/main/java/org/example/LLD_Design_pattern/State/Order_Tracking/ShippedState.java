package org.example.LLD_Design_pattern.State.Order_Tracking;

/**
 * Concrete State: SHIPPED
 * Logic: Order is in transit. 
 * Cancellations are typically restricted or trigger a different "Return" flow.
 */
public class ShippedState implements OrderState {

    @Override
    public void shipOrder(Order order) {
        // Idempotency check: If the logistics service calls us twice, we don't error out.
        System.out.println("Order is already in transit. Tracking ID: " + order.getTrackingId());
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Logistics confirmed delivery. Updating customer...");
        // Side Effect: Trigger "Order Delivered" Push Notification
        order.setState(new DeliveredState());
    }

    @Override
    public void cancelOrder(Order order) {
        /**
         * Lead Insight: Business logic usually dictates that shipped orders 
         * cannot be cancelled via the standard flow. 
         * Instead, we might initiate a 'Stop-and-Return' protocol with the carrier.
         */
        System.out.println("Cannot cancel: Order is already with the courier.");
        System.out.println("Redirecting to 'Return-to-Origin' (RTO) workflow...");
        // order.setState(new RTOInProgressState()); // Optional complex flow
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("Order was already paid and is currently shipped.");
    }

    @Override
    public String getStatus() {
        return "SHIPPED";
    }
}