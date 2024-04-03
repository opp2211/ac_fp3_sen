package ru.maltsev.alishevcourse.restsensorapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.maltsev.alishevcourse.restsensorapp.model.Measurement;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    @Query("SELECT m from Measurement m join fetch m.sensor")
    List<Measurement> findAllWithSensors();

    int countByRaining(Boolean raining);

    @Query(nativeQuery = true,
            value = "SELECT count(distinct cast(datetime as DATE)) from measurement where raining = ?1")
    int countDaysByRaining(Boolean raining);
}
