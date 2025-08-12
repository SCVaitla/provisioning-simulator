package com.nisc.provisioning.service.client;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class RestSwitchClient {
    private final Random rnd = new Random();
    public Map<String, Object> provision(String accountNumber, String serviceType, String action) {
        // Simulate REST call to network switch / head-end
        boolean ok = rnd.nextDouble() > 0.1; // 90% success for demo
        return Map.of(
                "platform", "REST",
                "status", ok ? "SUCCESS" : "FAILED",
                "message", ok ? "Activated via REST endpoint" : "REST switch timeout"
        );
    }
}
