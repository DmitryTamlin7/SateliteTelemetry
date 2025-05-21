package com.example.telemetry.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class TelemetryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double temperature;
    private int batteryLevel;

    // Исправлено имя поля и формат ISO с T для корректного парсинга на фронте
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public TelemetryData() {}

    public TelemetryData(double temperature, int batteryLevel, LocalDateTime timestamp) {
        this.temperature = temperature;
        this.batteryLevel = batteryLevel;
        this.timestamp = timestamp;
    }

    public TelemetryData(double temperature, int batteryLevel){
        this.temperature = temperature;
        this.batteryLevel = batteryLevel;
    }


    // Геттеры и сеттеры

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
