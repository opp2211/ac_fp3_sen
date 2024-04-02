package ru.maltsev.alishevcourse.restsensorapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsev.alishevcourse.restsensorapp.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    boolean existsByName(String name);
}
