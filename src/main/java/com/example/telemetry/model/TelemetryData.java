package com.example.telemetry.model;


import net.bytebuddy.asm.Advice;

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

    public TelemetryData() {}

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

    public TelemetryData(double temperature, int batteryLevel) {
        this.temperature = temperature;
        this.batteryLevel = batteryLevel;
    }

    private LocalDateTime  timetamp = LocalDateTime.now();

    public LocalDateTime getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(LocalDateTime timetamp) {
        this.timetamp = timetamp;
    }
}
