package com.nisc.provisioning.service.client;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class SoapHeadendClient {
    private final Random rnd = new Random();
    public Map<String, Object> provision(String accountNumber, String serviceType, String action) {
        // Simulate SOAP call to TV head-end
        boolean ok = rnd.nextDouble() > 0.15; // 85% success for demo
        return Map.of(
                "platform", "SOAP",
                "status", ok ? "SUCCESS" : "FAILED",
                "message", ok ? "Activated via SOAP endpoint" : "SOAP head-end fault"
        );
    }
}
