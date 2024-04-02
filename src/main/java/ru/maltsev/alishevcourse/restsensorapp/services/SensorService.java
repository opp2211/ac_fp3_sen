package ru.maltsev.alishevcourse.restsensorapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsev.alishevcourse.restsensorapp.model.Sensor;
import ru.maltsev.alishevcourse.restsensorapp.repositories.SensorRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

    @Transactional
    public void addNew(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
