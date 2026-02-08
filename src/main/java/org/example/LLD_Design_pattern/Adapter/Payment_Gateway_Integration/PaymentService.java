package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class PaymentService {
    private final PaymentOrchestrator orchestrator;
    // In production, use Redis with an Expiry time for this
    private final Map<String, PaymentResponse> idempotencyCache = new ConcurrentHashMap<>();

    public PaymentService(PaymentOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        // Return cached response if ID exists
        if (idempotencyCache.containsKey(request.transactionId())) {
            System.out.println("Returning cached response for: " + request.transactionId());
            return idempotencyCache.get(request.transactionId());
        }

        PaymentResponse response = orchestrator.route(request);
        idempotencyCache.put(request.transactionId(), response);
        return response;
    }
}