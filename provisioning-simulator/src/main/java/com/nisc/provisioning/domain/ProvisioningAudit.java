package com.nisc.provisioning.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class ProvisioningAudit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String serviceType;
    private String action;
    private String externalPlatform; // REST/SOAP
    private String status; // SUCCESS/FAILED
    @Column(length = 1024)
    private String details;
    private Instant createdAt = Instant.now();

    public ProvisioningAudit() {}
    public ProvisioningAudit(String accountNumber, String serviceType, String action,
                             String externalPlatform, String status, String details) {
        this.accountNumber = accountNumber;
        this.serviceType = serviceType;
        this.action = action;
        this.externalPlatform = externalPlatform;
        this.status = status;
        this.details = details;
    }
    public Long getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public String getServiceType() { return serviceType; }
    public String getAction() { return action; }
    public String getExternalPlatform() { return externalPlatform; }
    public String getStatus() { return status; }
    public String getDetails() { return details; }
    public java.time.Instant getCreatedAt() { return createdAt; }
}
