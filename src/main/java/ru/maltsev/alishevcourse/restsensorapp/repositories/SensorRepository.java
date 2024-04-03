package ru.maltsev.alishevcourse.restsensorapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsev.alishevcourse.restsensorapp.model.Sensor;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    boolean existsByName(String name);
    Optional<Sensor> findByName(String name);
}
