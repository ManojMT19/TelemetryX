package com.telemetryx.api.dto;

import java.time.LocalDateTime;

public class TelemetryResponse
{
    private Long telemetryId;
    private Long deviceId;
    private String serialNumber;
    private Double speed;
    private Double temperature;
    private boolean hazardous;
    private LocalDateTime timestamp;

    public Long getTelemetryId()
    {
        return telemetryId;
    }

    public void setTelemetryId(Long telemetryId)
    {
        this.telemetryId = telemetryId;
    }

    public Long getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public Double getSpeed()
    {
        return speed;
    }

    public void setSpeed(Double speed)
    {
        this.speed = speed;
    }

    public Double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(Double temperature)
    {
        this.temperature = temperature;
    }

    public boolean isHazardous()
    {
        return hazardous;
    }

    public void setHazardous(boolean hazardous)
    {
        this.hazardous = hazardous;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }
}
