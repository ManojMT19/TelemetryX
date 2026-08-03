package com.telemetryx.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StatsResponse
{
    private long totalDevices;
    private long totalTelemetryLogs;
    private double averageSpeed;
    private double averageTemperature;

    public long getTotalDevices()
    {
        return totalDevices;
    }

    public void setTotalDevices(long totalDevices)
    {
        this.totalDevices = totalDevices;
    }

    public long getTotalTelemetryLogs()
    {
        return totalTelemetryLogs;
    }

    public void setTotalTelemetryLogs(long totalTelemetryLogs)
    {
        this.totalTelemetryLogs = totalTelemetryLogs;
    }

    public double getAverageSpeed()
    {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed)
    {
        this.averageSpeed = averageSpeed;
    }

    public double getAverageTemperature()
    {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature)
    {
        this.averageTemperature = averageTemperature;
    }
}
