package com.example.telemetry.generator;

import com.example.telemetry.model.TelemetryData;
import com.example.telemetry.service.TelemetryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TelemetryGenerator {

    private final TelemetryService telemetryService;

    public TelemetryGenerator(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @Scheduled(fixedRate = 5000)
    public void generateAndSaveTelemetry() {
        double temp = 15 + Math.random() * 20;
        int battery = (int) (50 + Math.random() * 50);

        TelemetryData data = new TelemetryData(temp, battery);
        telemetryService.saveTelemetry(data);

        System.out.println("Generated telemetry: " + data);
    }
}
