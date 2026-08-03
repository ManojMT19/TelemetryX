package com.telemetryx.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController
{
    @GetMapping("/api/v1/system/heartbeat")
    public String HeartBeat()
    {
        return "TelemetryX API v1 is operational";
    }
}
