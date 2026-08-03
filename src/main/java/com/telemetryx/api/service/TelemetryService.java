package com.telemetryx.api.service;

import com.telemetryx.api.dto.DeviceStatsResponse;
import com.telemetryx.api.dto.StatsResponse;
import com.telemetryx.api.dto.TelemetryIngestRequest;
import com.telemetryx.api.entity.Device;
import com.telemetryx.api.entity.TelemetryData;
import com.telemetryx.api.exception.ResourceNotFoundException;
import com.telemetryx.api.repository.DeviceRepository;
import com.telemetryx.api.repository.TelemetryDataRepository;
import com.telemetryx.api.specification.TelemetrySpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.telemetryx.api.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TelemetryService
{
    private final DeviceRepository deviceRepository;
    private final TelemetryDataRepository telemetryDataRepository;

    public TelemetryService(DeviceRepository deviceRepository, TelemetryDataRepository telemetryDataRepository)
    {
        this.deviceRepository = deviceRepository;
        this.telemetryDataRepository = telemetryDataRepository;
    }

    public void processTelemetry(TelemetryIngestRequest request)
    {
        // 1. Validate the device exists
        Device device = deviceRepository.findById(request.getDeviceId()).orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        // 2. Map DTO data to the Entity
        TelemetryData data = new TelemetryData();

        data.setTemperature(request.getTemperature());
        data.setSpeed(request.getSpeed());
        data.setDevice(device);
        data.setTimestamp(LocalDateTime.now()); // Server-generated timestamp

        data.setHazardous(request.getTemperature() > 90 || request.getSpeed() > 120);

        // 3. Save it
        telemetryDataRepository.save(data);
    }

    public Page<TelemetryData> getTelemetry(
            Long deviceId,
            Boolean hazardous,
            Double minSpeed,
            Pageable pageable) // Specification
    {

        Specification<TelemetryData> spec = null;

        if (deviceId != null)
        {
            spec = TelemetrySpecification.hasDeviceId(deviceId);
        }

        if (hazardous != null && hazardous) {

            if (spec == null)
                spec = TelemetrySpecification.isHazardous();
            else
                spec = spec.and(TelemetrySpecification.isHazardous());
        }

        if(minSpeed != null)
        {
            if (spec == null)
                spec = TelemetrySpecification.minSpeed(minSpeed);
            else
                spec = spec.and(TelemetrySpecification.minSpeed(minSpeed));
        }

        if (spec == null)
            return telemetryDataRepository.findAll(pageable);

        return telemetryDataRepository.findAll(spec, pageable);
    }

    public StatsResponse getFleetStats()
    {
        // 1. Count devices using deviceRepository.count()
        // 2. Count telemetry logs using telemetryDataRepository.count()
        // 3. Fetch all logs and compute avgSpeed and avgTemp using Streams
        // 4. Create a new StatsResponse object, set all 4 values, and return it!

        long NoOfDevices = deviceRepository.count();
        long NoOfLogs = telemetryDataRepository.count();

        List<TelemetryData> logs = telemetryDataRepository.findAll();

        double avgSpeed = logs.stream()
                .mapToDouble(TelemetryData::getSpeed)
                .average()
                .orElse(0.0);

        double avgTemp = logs.stream()
                .mapToDouble(TelemetryData::getTemperature)
                .average()
                .orElse(0.0);

        avgSpeed = Math.round(avgSpeed * 100.0) / 100.0;
        avgTemp = Math.round(avgTemp * 100.0) / 100.0;

        StatsResponse response = new StatsResponse();
        
        response.setAverageSpeed(avgSpeed);
        response.setAverageTemperature(avgTemp);
        response.setTotalDevices(NoOfDevices);
        response.setTotalTelemetryLogs(NoOfLogs);

        return response;
    }

    public List<DeviceStatsResponse> getStatsPerDevice()
    {
        List<Device> devices = deviceRepository.findAllByOrderByIdAsc();

        List<DeviceStatsResponse> responseList = new ArrayList<>();

        for (Device dev : devices)
        {
            List<TelemetryData> logs = telemetryDataRepository.findAll();

            double avgSpeed = logs.stream().mapToDouble(TelemetryData :: getSpeed).average().orElse(0.0);

            double avgtemp = logs.stream().mapToDouble(TelemetryData :: getTemperature).average().orElse(0.0);

            avgSpeed = Math.round(avgSpeed * 100.0)/100.0;
            avgtemp = Math.round(avgtemp * 100.0)/100.0;

            DeviceStatsResponse dd = new DeviceStatsResponse();

            dd.setDeviceId(dev.getId());
            dd.setDeviceName(dev.getDeviceType());
            dd.setSerialNo(dev.getSerialNumber());
            dd.setAvgSpeed(avgSpeed);
            dd.setAvgTemp(avgtemp);
            dd.setTotalLogs(logs.size());

            responseList.add(dd);
        }
        return responseList;
    }

}




























