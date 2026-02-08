package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

public class Main {
    public static void main(String[] args) {
        PaymentOrchestrator orchestrator = new PaymentOrchestrator();
        orchestrator.registerGateway(new StripeGateway());
        orchestrator.registerGateway(new PayPalGateway());

        PaymentService service = new PaymentService(orchestrator);

        // Test 1: Auto-selection (No Hint)
        System.out.println("--- Test 1: Auto-Selection ---");
        service.processPayment(new PaymentRequest("TXN_1", 10.0, "USD", null, "CARD"));

        // Test 2: User Hint (Stripe)
        System.out.println("\n--- Test 2: User Preference ---");
        service.processPayment(new PaymentRequest("TXN_2", 25.0, "USD", "STRIPE", "CARD"));

        // Test 3: Idempotency (Retrying TXN_1)
        System.out.println("\n--- Test 3: Idempotency Retry ---");
        service.processPayment(new PaymentRequest("TXN_1", 10.0, "USD", null, "CARD"));
    }
}