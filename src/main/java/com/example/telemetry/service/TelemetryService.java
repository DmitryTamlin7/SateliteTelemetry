package com.example.telemetry.service;

import com.example.telemetry.model.TelemetryData;
import com.example.telemetry.repository.TelemetryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelemetryService {

    private static final String TOPIC = "Telemetry_topic";
    public List<TelemetryData> getAllTelemetry;

    @Autowired
    private TelemetryDataRepository repository;

    @Autowired
    private  KafkaTemplate<String,String> kafkaTemplate;

    public  TelemetryData saveTelemetry(TelemetryData data){
        TelemetryData saved = repository.save(data);

        //KAFKA
        String message = String.format(
                "{\"temperature\":%.2f,\"batteryLevel\":%d}",
                data.getTemperature(),
                data.getBatteryLevel()
        );
        kafkaTemplate.send(TOPIC, message);

        return saved;
    }

    public List<TelemetryData> getAllTelemetry() {
        return repository.findAll();
    }

    public List<TelemetryData> getFilterTelemetry(Double minTemp, Double maxTemp, Integer batteryLevel) {
        return repository.findByFilters(minTemp, maxTemp, batteryLevel);
    }
}
