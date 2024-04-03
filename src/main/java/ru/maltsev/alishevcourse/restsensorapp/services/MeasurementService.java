package ru.maltsev.alishevcourse.restsensorapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsev.alishevcourse.restsensorapp.exceptions.NotFoundException;
import ru.maltsev.alishevcourse.restsensorapp.model.Measurement;
import ru.maltsev.alishevcourse.restsensorapp.model.Sensor;
import ru.maltsev.alishevcourse.restsensorapp.repositories.MeasurementRepository;
import ru.maltsev.alishevcourse.restsensorapp.repositories.SensorRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Transactional
    public void addNew(Measurement measurement, String sensorName) {
        Sensor sensor = sensorRepository.findByName(sensorName)
                .orElseThrow(() -> new NotFoundException("Sensor name not found!"));
        measurement.setSensor(sensor);

        measurementRepository.save(measurement);
    }
}
