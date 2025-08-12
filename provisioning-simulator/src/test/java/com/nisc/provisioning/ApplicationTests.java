package com.nisc.provisioning;

import com.nisc.provisioning.domain.OrderRequest;
import com.nisc.provisioning.domain.ProvisioningAudit;
import com.nisc.provisioning.service.ProvisioningService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @Autowired
    ProvisioningService service;

    @Test
    void testProvisionFlow() {
        OrderRequest req = new OrderRequest();
        req.setAccountNumber("A1001");
        req.setServiceType("INTERNET");
        req.setAction("ACTIVATE");
        ProvisioningAudit audit = service.process(req);
        assertNotNull(audit.getId());
        assertTrue(audit.getStatus().equals("SUCCESS") || audit.getStatus().equals("FAILED"));
    }
}
