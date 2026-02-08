package org.example.LLD_Design_pattern.Adapter.Payment_Gateway_Integration;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class PaymentOrchestrator {
    private final Map<String, PaymentGateway> gatewayRegistry = new ConcurrentHashMap<>();

    public void registerGateway(PaymentGateway gateway) {
        gatewayRegistry.put(gateway.getGatewayName().toUpperCase(), gateway);
    }

    public PaymentResponse route(PaymentRequest request) {
        PaymentGateway selected = null;

        // 1. Check User Preference first
        if (request.gatewayHint() != null) {
            PaymentGateway preferred = gatewayRegistry.get(request.gatewayHint().toUpperCase());
            if (preferred != null && preferred.isHealthy()) {
                selected = preferred;
            } else {
                System.out.println("Preferred gateway " + request.gatewayHint() + " is unhealthy. Falling back.");
            }
        }

        // 2. Auto-select if no preference or preference failed
        if (selected == null) {
            selected = gatewayRegistry.values().stream()
                .filter(PaymentGateway::isHealthy)
                .max(Comparator.comparingDouble(PaymentGateway::getSuccessRate))
                .orElseThrow(() -> new RuntimeException("All payment gateways are currently offline."));
        }

        return selected.process(request);
    }
}