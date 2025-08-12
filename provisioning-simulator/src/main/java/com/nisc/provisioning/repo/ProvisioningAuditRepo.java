package com.nisc.provisioning.repo;

import com.nisc.provisioning.domain.ProvisioningAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvisioningAuditRepo extends JpaRepository<ProvisioningAudit, Long> { }
