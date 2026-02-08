package org.example.LLD_Design_pattern.State.Order_Tracking;

/**
 * Concrete State: DELIVERED
 * Logic: The final stage of the fulfillment lifecycle.
 * Actions like 'pay' or 'ship' are now irrelevant (No-Op or Exception).
 */
public class DeliveredState implements OrderState {

    @Override
    public void deliverOrder(Order order) {
        // Idempotency: Handling duplicate delivery signals from logistics partners
        System.out.println("Order is already marked as Delivered.");
    }

    @Override
    public void cancelOrder(Order order) {
        /**
         * Lead Insight: You can't "cancel" a delivered order. 
         * You must "Return" it. This demonstrates an understanding of 
         * Business Domain vs. Technical State.
         */
        System.out.println("Cannot cancel a delivered order. Please initiate a 'Return' request.");
    }

    @Override
    public void confirmPayment(Order order) {
        System.out.println("Order was paid and delivered successfully.");
    }

    @Override
    public void shipOrder(Order order) {
        throw new IllegalStateException("Order has already been delivered to the customer.");
    }

    @Override
    public String getStatus() {
        return "DELIVERED";
    }
}