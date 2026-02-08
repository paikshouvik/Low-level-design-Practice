package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

// The standard response format
record PaymentResponse(
        String transactionId,
        String status,
        String gatewayUsed,
        String message
) {
}
