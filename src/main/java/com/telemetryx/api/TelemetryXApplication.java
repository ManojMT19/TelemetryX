package com.telemetryx.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelemetryXApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TelemetryXApplication.class, args);
	}
}

/*

I am continuing the development of my Spring Boot backend project called "TelemetryX" (a vehicle telemetry and fleet management tracking system).

Here is everything we have built so far, along with the exact class and method names. Do not deviate from these names or patterns unless explicitly asked:

### 1. Existing Project Tech Stack & Structure
* Java & Spring Boot (MVC architecture)
* PostgreSQL Database with Spring Data JPA

### 2. Existing Entities & Repositories
* **Device Entity (`com.telemetryx.api.entity.Device`)**
  * Fields: `id` (Long), `name` (String), `serialNumber` (String)
* **TelemetryData Entity (`com.telemetryx.api.entity.TelemetryData`)**
  * Fields: `id` (Long), `speed` (double), `temperature` (double), `timestamp`, and a relationship to `Device` (`device_id`).
* **DeviceRepository (`com.telemetryx.api.repository.DeviceRepository`)**
  * Method: `findAll()`
* **TelemetryDataRepository (`com.telemetryx.api.repository.TelemetryDataRepository`)**
  * Method: `findByDeviceIdOrderByIdAsc(Long deviceId)`

### 3. Existing DTOs
* **`StatsResponse` (`com.telemetryx.api.dto.StatsResponse`)**
  * Holds global fleet statistics (total devices, total logs, fleet-wide averages).
* **`DeviceStatsResponse` (`com.telemetryx.api.dto.DeviceStatsResponse`)**
  * Fields: `deviceId` (Long), `deviceName` (String), `serialNo` (String), `totalLogs` (long), `avgSpeed` (double), `avgTemp` (double).

### 4. Existing Services & Controllers
* **`TelemetryService` (`com.telemetryx.api.service.TelemetryService`)**
  * Has `getStatsPerDevice()` which loops through all devices, fetches their specific telemetry logs using `findByDeviceIdOrderByIdAsc(...)`, calculates and rounds individual averages (`avgSpeed`, `avgTemp`), maps them into `DeviceStatsResponse` DTOs, and returns a `List<DeviceStatsResponse>`.
* **`TelemetryController` (`com.telemetryx.api.controller.TelemetryController`)**
  * Exposes endpoints including `GET /api/v1/telemetry/device-stats` which returns `List<DeviceStatsResponse>`.

---

### What We Need to Do Next
Help me continue building out the next features of this project according to a standard backend roadmap (such as query filtering by device ID, hazard rule evaluations, or pagination).

Maintain a direct, no-nonsense, logical coaching style—challenge my assumptions, explain the "why" behind architecture decisions, and don't give unnecessary fluff. Let's pick up right here. What should we build next?
* */
