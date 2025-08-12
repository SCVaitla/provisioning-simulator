package com.nisc.provisioning.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String accountNumber;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneE164;

    public Customer() {}
    public Customer(String accountNumber, String name, String phoneE164) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.phoneE164 = phoneE164;
    }
    public Long getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneE164() { return phoneE164; }
    public void setPhoneE164(String phoneE164) { this.phoneE164 = phoneE164; }
}
