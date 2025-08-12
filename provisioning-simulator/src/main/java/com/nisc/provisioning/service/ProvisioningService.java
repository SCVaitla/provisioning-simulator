package com.nisc.provisioning.service;

import com.nisc.provisioning.domain.OrderRequest;
import com.nisc.provisioning.domain.ProvisioningAudit;
import com.nisc.provisioning.repo.ProvisioningAuditRepo;
import com.nisc.provisioning.service.client.RestSwitchClient;
import com.nisc.provisioning.service.client.SoapHeadendClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class ProvisioningService {
    private final RestSwitchClient restClient;
    private final SoapHeadendClient soapClient;
    private final ProvisioningAuditRepo auditRepo;

    public ProvisioningService(RestSwitchClient restClient, SoapHeadendClient soapClient,
                               ProvisioningAuditRepo auditRepo) {
        this.restClient = restClient;
        this.soapClient = soapClient;
        this.auditRepo = auditRepo;
    }

    @Transactional
    public ProvisioningAudit process(OrderRequest req) {
        Map<String, Object> res1 = restClient.provision(req.getAccountNumber(), req.getServiceType(), req.getAction());
        Map<String, Object> res2 = soapClient.provision(req.getAccountNumber(), req.getServiceType(), req.getAction());

        // If any platform succeeds, treat as success for demo
        String status = ("SUCCESS".equals(res1.get("status")) || "SUCCESS".equals(res2.get("status"))) ? "SUCCESS" : "FAILED";
        String details = String.format("REST: %s | SOAP: %s", res1.get("message"), res2.get("message"));

        ProvisioningAudit audit = new ProvisioningAudit(
                req.getAccountNumber(),
                req.getServiceType(),
                req.getAction(),
                status.equals("SUCCESS") ? "MULTI" : "MULTI",
                status,
                details
        );
        return auditRepo.save(audit);
    }
}
