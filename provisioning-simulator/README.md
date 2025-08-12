# NISC-Style Provisioning Simulator (Micro-Project)

A compact, production-lean Spring Boot project that demonstrates **provisioning**, **third-party API integration (REST + SOAP mock)**, **data conversion/migration**, and an **auditable trail**—modeled after the responsibilities in the NISC Provisioning Implementation role.

## Why it’s relevant
- Mirrors the **provisioning** flow to network switches/head-ends (mocked REST + SOAP clients).
- Includes **data migration** from legacy CSV to a normalized DB with **E.164** phone transformation.
- Provides **auditing** for every provisioning attempt and an API to query history.
- Uses tools/keywords from the JD: **Java, REST, SOAP (mock), XML-ready, XSLT-ready, Linux, SQL, testing**.

## Quick Start
```bash
# Prereqs: JDK 17+, Maven 3.9+
mvn spring-boot:run
```

### Endpoints
- `POST /api/provision`
```json
{
  "accountNumber": "A1001",
  "serviceType": "INTERNET",
  "action": "ACTIVATE"
}
```
- `GET /api/audits` – list all provisioning audit records.

### Data Migration
On startup, the app loads `data/sample/customers.csv`, converts phone numbers to **E.164**, and persists **Customer** records.

## Extend (Interview Talking Points)
- Replace mocked clients with real **SOAP** bindings (JAX-WS) and **REST** calls.
- Add **XSLT** transform for XML payload shape; add **expect4j** for CLI-based device provisioning.
- Introduce **QA suite**: JUnit for service + controller tests and testcontainers for DB. 
- Harden reliability with **retry/backoff**, **idempotency keys**, and **circuit breaking**. 
- Add **role-based auditing** and **Confluence-ready** runbooks.

## Sample cURL
```bash
curl -X POST http://localhost:8080/api/provision   -H "Content-Type: application/json"   -d '{"accountNumber":"A1001","serviceType":"INTERNET","action":"ACTIVATE"}'

curl http://localhost:8080/api/audits
```
