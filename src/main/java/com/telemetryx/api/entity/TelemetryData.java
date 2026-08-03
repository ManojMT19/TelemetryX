package com.telemetryx.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry_data")
public class TelemetryData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double temperature;
    private Double speed;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name ="device_id",nullable=false)
    private Device device;

    @Column(nullable = false)
    private boolean hazardous;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public Device getDevice()
    {
        return device;
    }

    public void setDevice(Device device)
    {
        this.device = device;
    }

    public boolean isHazardous()
    {
        return hazardous;
    }

    public void setHazardous(boolean hazardous)
    {
        this.hazardous = hazardous;
    }
}
