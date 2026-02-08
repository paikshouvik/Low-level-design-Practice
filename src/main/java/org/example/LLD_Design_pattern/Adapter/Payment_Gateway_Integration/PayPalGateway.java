package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

class PayPalGateway implements PaymentGateway {
    @Override
    public String getGatewayName() {
        return "PAYPAL";
    }

    @Override
    public boolean isHealthy() {
        return true;
    }

    @Override
    public double getSuccessRate() {
        return 0.95;
    }

    @Override
    public PaymentResponse process(PaymentRequest request) {
        // In reality, this would handle PayPal's OAuth and Order API
        System.out.println("[PayPal] API Call: Authorizing " + request.amount());
        return new PaymentResponse(request.transactionId(), "SUCCESS", "PAYPAL", "Processed via PayPal");
    }
}
