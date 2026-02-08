package org.example.LLD_Design_pattern.State.Order_Tracking;

public class ConfirmedState implements OrderState {
    @Override
    public void shipOrder(Order order) {
        System.out.println("Order assigned to logistics. Transitioning to SHIPPED.");
        order.setState(new ShippedState());
        // Side Effect: Trigger "Order Shipped" SMS/Email
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Processing refund... Order cancelled.");
        order.setState(new CancelledState());
    }

    @Override public void confirmPayment(Order o) { System.out.println("Already confirmed."); }
    @Override public void deliverOrder(Order o) { throw new IllegalStateException("Can't deliver before shipping."); }
    @Override public String getStatus() { return "CONFIRMED"; }
}