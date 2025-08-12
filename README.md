Provisioning Simulator

A microservice prototype inspired by NISC's Provisioning Implementation process.  
Simulates provisioning and auditing across multiple platforms (REST + SOAP) with persistent audit logs, basic data migration, and phone number normalization.

## Features
- **Multi-Platform Provisioning**  
  Simultaneous mock REST and SOAP activation/deactivation flows.
- **Audit Logging**  
  Every request is stored with timestamps, status, and details.
- **Data Migration Utility**  
  Loads customer data from CSV, normalizes phone numbers to E.164.
- **Java + Spring Boot Stack**  
  REST API, JPA/Hibernate, H2 in-memory DB.
- **Extensible Architecture**  
  Ready for real SOAP bindings, XSLT transformations, and retry logic.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Maven

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.x

### Running the Application
```bash
# Clone the repo
git clone https://github.com/your-username/nisc-provisioning-simulator.git
cd nisc-provisioning-simulator

# Start the app
mvn spring-boot:run
