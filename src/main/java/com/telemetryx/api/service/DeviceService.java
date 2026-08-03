package com.telemetryx.api.service;

import com.telemetryx.api.entity.Device;
import com.telemetryx.api.repository.DeviceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceService
{

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository)
    {
        this.deviceRepository = deviceRepository;
    }

    public Device registerDevice(Device device)
    {
        // Future logic can go here (e.g., check if license plate already exists)
        return deviceRepository.save(device);
    }

    public List<Device> getAllDevicesSorted()
    {
        return deviceRepository.findAllByOrderByIdAsc();
    }
}