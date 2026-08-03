# 🚚 TelemetryX API

TelemetryX is a Spring Boot REST API that simulates a vehicle telemetry management system. It demonstrates how backend services can collect, process, store, and expose telemetry data from connected vehicles through RESTful APIs.

The project focuses on building scalable backend services using Spring Boot, Spring Data JPA, and PostgreSQL while implementing production-oriented features such as pagination, sorting, dynamic filtering using JPA Specifications, and DTO-based API responses.

---

## 📌 Problem Statement

Modern fleet management systems continuously receive telemetry data such as vehicle speed and engine temperature. As the number of vehicles and telemetry records grows, efficiently storing, retrieving, filtering, and analyzing this data becomes increasingly challenging.

TelemetryX demonstrates a backend solution that addresses these challenges by providing scalable REST APIs for telemetry ingestion, hazard detection, and fleet analytics.

---

## ✨ Features

- Vehicle Registration
- Telemetry Data Ingestion
- Hazard Detection based on configurable rules
- Fleet Statistics
- Device-wise Statistics
- Pagination
- Sorting
- Dynamic Filtering using JPA Specifications
- DTO-based API Responses

---

## 🛠 Tech Stack

- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- REST APIs

---

## 🏗 Project Architecture

```text
Controller
      ↓
Service
      ↓
Repository
      ↓
PostgreSQL
```

---

## 📊 Project Status

### ✅ Completed

- Vehicle Registration
- Telemetry Ingestion
- Hazard Detection
- Fleet Statistics
- Device Statistics
- Pagination
- Sorting
- Dynamic Filtering (JPA Specifications)
- DTO-based Responses

### 🚧 Planned

- Request Validation
- Global Exception Handling
- Swagger / OpenAPI Documentation
- JWT Authentication (Spring Security)
- Docker
- Cloud Deployment

---

