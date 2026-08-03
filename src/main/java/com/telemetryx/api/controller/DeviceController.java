package com.telemetryx.api.controller;

import com.telemetryx.api.entity.Device;
import com.telemetryx.api.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController
{
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService)
    {
        this.deviceService = deviceService;
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device)
    {
        Device savedDevice = deviceService.registerDevice(device);
        return ResponseEntity.ok(savedDevice);
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices()
    {
        List<Device> devices = deviceService.getAllDevicesSorted();
        return ResponseEntity.ok(devices);
    }
}