package org.example.LLD_Design_pattern.State.Order_Tracking;

public class CreatedState implements OrderState {
    @Override
    public void confirmPayment(Order order) {
        System.out.println("Payment successful. Transitioning to CONFIRMED.");
        // Logic: Convert 'provisional' inventory to 'blocked'
        order.setState(new ConfirmedState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order cancelled by user. Releasing provisional inventory.");
        order.setState(new CancelledState());
    }

    // Invalid transitions for this state
    @Override public void shipOrder(Order o) { throw new IllegalStateException("Pay first!"); }
    @Override public void deliverOrder(Order o) { throw new IllegalStateException("Not even shipped yet!"); }
    @Override public String getStatus() { return "CREATED"; }
}