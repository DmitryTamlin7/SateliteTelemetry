package com.example.telemetry.service;

import com.example.telemetry.model.TelemetryData;
import com.example.telemetry.repository.TelemetryDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TelemetryServiceTest {

    @Mock
    private TelemetryDataRepository repository;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private TelemetryService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTelemetry_savesDataAndSendsKafkaMessage() {
        TelemetryData data = new TelemetryData(25.0, 80);
        TelemetryData saved = new TelemetryData(25.0, 80);
        saved.setId(1L);

        when(repository.save(data)).thenReturn(saved);

        TelemetryData result = service.saveTelemetry(data);

        assertEquals(25.0, result.getTemperature());
        assertEquals(80, result.getBatteryLevel());
        verify(kafkaTemplate, times(1)).send(eq("Telemetry_topic"), contains("25.0"));
    }

    @Test
    void testGetAllTelemetry_returnsList() {
        List<TelemetryData> expectedList = Arrays.asList(
                new TelemetryData(22.0, 90),
                new TelemetryData(24.5, 85)
        );

        when(repository.findAll()).thenReturn(expectedList);

        List<TelemetryData> actual = service.getAllTelemetry();

        assertEquals(2, actual.size());
        assertEquals(90, actual.get(0).getBatteryLevel());
    }

    @Test
    void testGetFilteredTelemetry_filtersCorrectly() {
        List<TelemetryData> filtered = List.of(new TelemetryData(23.0, 80));
        when(repository.findByFilters(20.0, 25.0, 80)).thenReturn(filtered);

        List<TelemetryData> result = service.getFilterTelemetry(20.0, 25.0, 80);

        assertEquals(1, result.size());
        assertEquals(23.0, result.get(0).getTemperature());
    }
}

