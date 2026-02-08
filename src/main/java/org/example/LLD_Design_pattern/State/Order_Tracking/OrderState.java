package org.example.LLD_Design_pattern.State.Order_Tracking;

public interface OrderState {
    void confirmPayment(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
    void cancelOrder(Order order);
    String getStatus();
}