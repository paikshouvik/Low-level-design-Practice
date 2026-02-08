package org.example.LLD_Design_pattern.State.Order_Tracking;

import java.util.List;

public class Order {
    private String orderId;
    private OrderState currentState;
    private List<String> items;

    public Order(String orderId, List<String> items) {
        this.orderId = orderId;
        this.items = items;
        this.currentState = new CreatedState(); // Initial State
    }

    protected void setState(OrderState state) {
        this.currentState = state;
    }

    public String getTrackingId() {
        return "EKART"+this.orderId;
    }

    public void ship() {
        currentState.shipOrder(this);
    }

    public void confirmPayment() {
        currentState.confirmPayment(this);
    }

    public void cancel() {
        currentState.cancelOrder(this);
    }

    public void deliver() {
        currentState.deliverOrder(this);
    }

    public String getStatus() {
        return currentState.getStatus();
    }
}