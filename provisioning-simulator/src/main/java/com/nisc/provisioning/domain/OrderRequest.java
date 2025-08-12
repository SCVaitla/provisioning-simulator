package com.nisc.provisioning.domain;

import jakarta.validation.constraints.NotBlank;

public class OrderRequest {
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String serviceType; // INTERNET/TV/VOICE
    @NotBlank
    private String action; // ACTIVATE/DEACTIVATE

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
}
