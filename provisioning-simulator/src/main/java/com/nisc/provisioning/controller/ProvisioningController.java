package com.nisc.provisioning.controller;

import com.nisc.provisioning.domain.OrderRequest;
import com.nisc.provisioning.domain.ProvisioningAudit;
import com.nisc.provisioning.repo.ProvisioningAuditRepo;
import com.nisc.provisioning.service.ProvisioningService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProvisioningController {
    private final ProvisioningService provisioningService;
    private final ProvisioningAuditRepo auditRepo;

    public ProvisioningController(ProvisioningService provisioningService, ProvisioningAuditRepo auditRepo) {
        this.provisioningService = provisioningService;
        this.auditRepo = auditRepo;
    }

    @PostMapping("/provision")
    public ResponseEntity<ProvisioningAudit> provision(@Valid @RequestBody OrderRequest req) {
        return ResponseEntity.ok(provisioningService.process(req));
    }

    @GetMapping("/audits")
    public ResponseEntity<?> audits() {
        return ResponseEntity.ok(auditRepo.findAll());
    }
}
