package org.example.LLD_Design_pattern.State.Order_Tracking;

/**
 * Concrete State: CANCELLED
 * Logic: A terminal state. Once cancelled, an order is effectively "dead"
 * for the fulfillment pipeline.
 */
public class CancelledState implements OrderState {

    @Override
    public void cancelOrder(Order order) {
        // Idempotency: Ignore if the user clicks 'cancel' multiple times
        System.out.println("Order is already cancelled.");
    }

    @Override
    public void confirmPayment(Order order) {
        /**
         * Lead Insight: Handle edge cases. If a payment webhook arrives 
         * AFTER a cancellation, we must trigger an automatic refund.
         */
        System.out.println("Payment received for cancelled order. Triggering auto-refund...");
        // internalRefundService.refund(order.getOrderId());
    }

    @Override
    public void shipOrder(Order order) {
        throw new IllegalStateException("Cannot ship an order that has been cancelled.");
    }

    @Override
    public void deliverOrder(Order order) {
        throw new IllegalStateException("Cannot deliver a cancelled order.");
    }

    @Override
    public String getStatus() {
        return "CANCELLED";
    }
}