package com.telemetryx.api.dto;

public class DeviceStatsResponse
{
    private Long deviceId;
    private String deviceName;
    private String serialNo;
    private long totalLogs;
    private double avgSpeed;
    private double avgTemp;

    public Long getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getSerialNo()
    {
        return serialNo;
    }

    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }

    public long getTotalLogs()
    {
        return totalLogs;
    }

    public void setTotalLogs(long totalLogs)
    {
        this.totalLogs = totalLogs;
    }

    public double getAvgSpeed()
    {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed)
    {
        this.avgSpeed = avgSpeed;
    }

    public double getAvgTemp()
    {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp)
    {
        this.avgTemp = avgTemp;
    }
}
