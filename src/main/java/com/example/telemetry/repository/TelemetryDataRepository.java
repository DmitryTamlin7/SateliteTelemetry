package com.example.telemetry.repository;

import com.example.telemetry.model.TelemetryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface TelemetryDataRepository extends JpaRepository<TelemetryData, Long> {

    @Query("SELECT t FROM TelemetryData t WHERE " +
            "(:minTemp IS NULL OR t.temperature >= :minTemp) AND" +
            "(:maxTemp IS NULL OR t.temperature <= :maxTemp) AND" +
            "(:batteryLevel IS NOT NULL OR t.batteryLevel = :batterylevel)")
    List<TelemetryData> findByFilters(        @RequestParam("minTemp") Double minTemp,
                                              @RequestParam("maxTemp") Double maxTemp,
                                              @RequestParam("batteryLevel") Integer batteryLevel);


}
