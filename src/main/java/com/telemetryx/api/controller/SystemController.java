package com.telemetryx.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController
{
    @GetMapping("/system")
    public String HeartBeat()
    {
        System.out.println("Welcome to my Project  !!!");
        return "TelemetryX API v1 is operational";
    }
}
