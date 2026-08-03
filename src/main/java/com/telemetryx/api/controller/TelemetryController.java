package com.telemetryx.api.controller;

import com.telemetryx.api.dto.DeviceStatsResponse;
import com.telemetryx.api.dto.StatsResponse;
import com.telemetryx.api.dto.TelemetryIngestRequest;
import com.telemetryx.api.dto.TelemetryResponse;
import com.telemetryx.api.entity.TelemetryData;
import com.telemetryx.api.repository.TelemetryDataRepository;
import com.telemetryx.api.service.TelemetryService;
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
    public ResponseEntity<String> ingestData(@RequestBody TelemetryIngestRequest request)
    {
        telemetryService.processTelemetry(request);
        return ResponseEntity.ok("Telemetry data ingested successfully");
    }

    @GetMapping
    public ResponseEntity<Page<TelemetryResponse>> getTelemetry(
            @RequestParam(required = false) Long deviceId ,
            @RequestParam(required = false) Boolean hazardous ,
            @RequestParam(required = false) Double minSpeed, Pageable pageable)
    {
        return ResponseEntity.ok(telemetryService.getTelemetry(deviceId, hazardous, minSpeed, pageable));
    }

    @GetMapping("/stats")
    public StatsResponse getStats()
    {
        return telemetryService.getFleetStats();
    }

    @GetMapping("/device-stats")
    public List<DeviceStatsResponse> getDeviceStats()
    {
        return telemetryService.getStatsPerDevice();
    }


}
