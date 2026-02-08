package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

// The standard request format for our system
record PaymentRequest(
    String transactionId, 
    double amount, 
    String currency, 
    String gatewayHint, 
    String method
) {}

