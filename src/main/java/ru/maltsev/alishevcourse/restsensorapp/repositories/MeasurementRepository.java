package ru.maltsev.alishevcourse.restsensorapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maltsev.alishevcourse.restsensorapp.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
