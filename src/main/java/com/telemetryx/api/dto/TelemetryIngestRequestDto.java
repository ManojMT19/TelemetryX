package com.telemetryx.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TelemetryIngestRequestDto
{
    @NotNull(message = "Device ID is required")
    private Long deviceId;

    @NotNull(message = "Temperature is required")
    @Positive(message = "Temperature must be greater than 0")
    private Double temperature;

    @NotNull(message = "Speed is required")
    @Positive(message = "Speed must be greater than 0")
    private Double speed;

    public Long getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public Double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(Double temperature)
    {
        this.temperature = temperature;
    }

    public Double getSpeed()
    {
        return speed;
    }

    public void setSpeed(Double speed)
    {
        this.speed = speed;
    }
}
