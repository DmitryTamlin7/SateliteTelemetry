package com.example.telemetry.controller;

import com.example.telemetry.model.TelemetryData;
import com.example.telemetry.service.TelemetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService telemetryService;

    @GetMapping
    public List<TelemetryData> getAllTelemetry() {
        return telemetryService.getAllTelemetry();
    }

    @PostMapping
    public TelemetryData addTelemetry(@RequestBody TelemetryData data) {
        return telemetryService.saveTelemetry(data);
    }

    @GetMapping("/filter")
    public List<TelemetryData> getFilterTelemetry(
            @RequestParam(required = false) Double minTemp,
            @RequestParam(required = false) Double maxTemp,
            @RequestParam(required = false) Integer batteryLevel) {
        return telemetryService.getFilterTelemetry(minTemp, maxTemp, batteryLevel);
    }
}
