package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

// The interface all Gateways must implement
interface PaymentGateway {
    String getGatewayName();

    boolean isHealthy();

    double getSuccessRate();

    PaymentResponse process(PaymentRequest request);
}
