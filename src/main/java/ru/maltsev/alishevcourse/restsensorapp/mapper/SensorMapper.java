package ru.maltsev.alishevcourse.restsensorapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.maltsev.alishevcourse.restsensorapp.dto.SensorRequestDto;
import ru.maltsev.alishevcourse.restsensorapp.model.Sensor;

@Component
public class SensorMapper {
    private final ModelMapper modelMapper;

    public SensorMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Sensor toSensor(SensorRequestDto sensorRequestDto) {
        return modelMapper.map(sensorRequestDto, Sensor.class);
    }
}