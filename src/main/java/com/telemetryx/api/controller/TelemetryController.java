package com.telemetryx.api.controller;

import com.telemetryx.api.dto.DeviceStatsResponseDto;
import com.telemetryx.api.dto.StatsResponseDto;
import com.telemetryx.api.dto.TelemetryIngestRequestDto;
import com.telemetryx.api.dto.TelemetryResponseDto;
import com.telemetryx.api.service.TelemetryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
        name = "Telemetry API",
        description = "APIs for ingesting and monitoring vehicle telemetry data"
)

@RestController
@RequestMapping("/api/v1/telemetry")
public class TelemetryController
{
    private final TelemetryService telemetryService;

    public TelemetryController(TelemetryService telemetryService)
    {
        this.telemetryService = telemetryService;
    }


    @Operation(summary = "Ingest telemetry data")
    @PostMapping("/ingest")
    public ResponseEntity<String> ingestData(@Valid @RequestBody TelemetryIngestRequestDto request)
    {
        telemetryService.processTelemetry(request);
        return ResponseEntity.ok("Telemetry data ingested successfully");
    }

    @Operation(summary = "Get telemetry data with pagination, sorting and filtering")
    @GetMapping
    public ResponseEntity<Page<TelemetryResponseDto>> getTelemetry(
            @RequestParam(required = false) Long deviceId ,
            @RequestParam(required = false) Boolean hazardous ,
            @RequestParam(required = false) Double minSpeed, Pageable pageable)
    {
        return ResponseEntity.ok(telemetryService.getTelemetry(deviceId, hazardous, minSpeed, pageable));
    }

    @Operation(summary = "Get fleet statistics")
    @GetMapping("/stats")
    public StatsResponseDto getStats()
    {
        return telemetryService.getFleetStats();
    }

    @Operation(summary = "Get statistics for all devices")
    @GetMapping("/device-stats")
    public List<DeviceStatsResponseDto> getDeviceStats()
    {
        return telemetryService.getStatsPerDevice();
    }


}
