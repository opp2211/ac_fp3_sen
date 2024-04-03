package ru.maltsev.alishevcourse.restsensorapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.maltsev.alishevcourse.restsensorapp.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    int countByRaining(Boolean raining);

    @Query(nativeQuery = true,
            value = "SELECT count(distinct cast(datetime as DATE)) from measurement where raining = ?1")
    int countDaysByRaining(Boolean raining);
}
