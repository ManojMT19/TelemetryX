

# 🚚 TelemetryX API

TelemetryX is a production-ready, containerized Spring Boot REST API designed to simulate a scalable vehicle telemetry management system. It demonstrates how backend services can securely collect, process, store, and expose massive amounts of telemetry data from connected vehicle fleets.

## 📌 Problem Statement

Modern fleet management systems are flooded with continuous, high-frequency data streams (speed, engine temperature, hazard alerts). As fleets grow, backend systems face massive challenges in storing, securely authenticating, and dynamically filtering this data without crashing. 

TelemetryX solves this by providing a highly optimized, strictly layered REST API architecture that handles dynamic data ingestion, strict role-based access control, and containerized deployment for instant scaling.

## 🚀 Core Engineering Features

* **Business Logic:** Configurable hazard detection rules, device-wise analytics, and fleet-wide statistics aggregation.
* **Secure Authentication:** Stateless, role-based access control utilizing Spring Security and custom JWT (JSON Web Token) filters.
* **Advanced Data Retrieval:** Heavy utilization of JPA Specifications for dynamic filtering, alongside optimized Pagination and Sorting to prevent memory overload.
* **Containerized Infrastructure:** Zero-configuration local deployment using Docker and Docker Compose (Java 17 + PostgreSQL).
* **Resilient Architecture:** Strict DTO (Data Transfer Object) patterns to prevent data leakage and a centralized `GlobalExceptionHandler` to ensure the API never returns raw stack traces.
* **Interactive Documentation:** Real-time API exploration via integrated Swagger/OpenAPI.

## 🛠 Tech Stack

* **Core:** Java 17, Spring Boot
* **Security:** Spring Security, JWT
* **Database:** PostgreSQL, Spring Data JPA, Hibernate
* **Deployment:** Docker, Docker Compose
* **Build Tool:** Maven

## 🐳 Local Quick Start (Docker)

This project is completely containerized. You do not need to install Java or PostgreSQL locally to run it.

### 1. Build and Run
Ensure Docker Desktop is running, then execute this command in the project root:
```bash
docker compose up --build

```

### 2. Access the Application

Once the database and API containers are initialized, the application maps to your local machine:

* **Base URL:** `http://localhost:8080` (docker)
* **Swagger UI / API Docs:** `http://localhost:8080/swagger-ui.html` (docker)

### 3. Authentication Flow

1. Send a `POST` request to `/api/v1/auth/register` to create a user.
2. Receive a Bearer JWT in the response.
3. Include `Bearer <token>` in the `Authorization` header for all protected telemetry endpoints.

### 4. Shut Down

To gracefully kill the containers while preserving your database records on the local volume:

```bash
docker compose down

```

## 🏗 System Architecture

The application strictly enforces separation of concerns:

```text
Client Request (JWT Bearer)
      ↓
[ Security Filter Chain ] → Validates Token & Roles
      ↓
[ Controller Layer ] → Handles HTTP / Routing
      ↓
[ DTO Mapper ] → Transforms Payloads
      ↓
[ Service Layer ] → Executes Core Business Logic
      ↓
[ Repository Layer ] → JPA Specifications & Queries
      ↓
[ PostgreSQL ] (Dockerized Database)

```

