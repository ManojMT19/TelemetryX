package com.telemetryx.api.controller;

import com.telemetryx.api.dto.DeviceStatsResponseDto;
import com.telemetryx.api.dto.StatsResponseDto;
import com.telemetryx.api.dto.TelemetryIngestRequestDto;
import com.telemetryx.api.dto.TelemetryResponseDto;
import com.telemetryx.api.service.TelemetryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/telemetry")
public class TelemetryController
{
    private final TelemetryService telemetryService;

    public TelemetryController(TelemetryService telemetryService)
    {
        this.telemetryService = telemetryService;
    }

    @PostMapping("/ingest")
    public ResponseEntity<String> ingestData(@Valid @RequestBody TelemetryIngestRequestDto request)
    {
        telemetryService.processTelemetry(request);
        return ResponseEntity.ok("Telemetry data ingested successfully");
    }

    @GetMapping
    public ResponseEntity<Page<TelemetryResponseDto>> getTelemetry(
            @RequestParam(required = false) Long deviceId ,
            @RequestParam(required = false) Boolean hazardous ,
            @RequestParam(required = false) Double minSpeed, Pageable pageable)
    {
        return ResponseEntity.ok(telemetryService.getTelemetry(deviceId, hazardous, minSpeed, pageable));
    }

    @GetMapping("/stats")
    public StatsResponseDto getStats()
    {
        return telemetryService.getFleetStats();
    }

    @GetMapping("/device-stats")
    public List<DeviceStatsResponseDto> getDeviceStats()
    {
        return telemetryService.getStatsPerDevice();
    }


}
