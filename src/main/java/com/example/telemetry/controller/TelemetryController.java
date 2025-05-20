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
    private TelemetryService service;

    @PostMapping
    public  TelemetryData postTelemetry(@RequestBody TelemetryData data){
        return service.saveTelemetry(data);
    }

    @GetMapping
    public  List<TelemetryData> getAllTelemetry() {
        return service.getAllTelemetry();
    }

    @GetMapping("/filter")
    public List<TelemetryData> getTelemetryFilter(
            @RequestParam(required = false) Double minTemp,
            @RequestParam(required = false) Double maxTemp,
            @RequestParam(required = false) Integer batteryLevel) {

        return service.getFilterTelemetry(minTemp, maxTemp, batteryLevel);
    }



}
