package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

class StripeGateway implements PaymentGateway {
    @Override public String getGatewayName() { return "STRIPE"; }
    @Override public boolean isHealthy() { return true; }
    @Override public double getSuccessRate() { return 0.99; }

    @Override
    public PaymentResponse process(PaymentRequest request) {
        // In reality, this would use Stripe's SDK (e.g., PaymentIntent.create())
        System.out.println("[Stripe] API Call: Charging " + request.amount());
        return new PaymentResponse(request.transactionId(), "SUCCESS", "STRIPE", "Processed via Stripe");
    }
}

