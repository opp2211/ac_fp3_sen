package ru.maltsev.alishevcourse.restsensorapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.maltsev.alishevcourse.restsensorapp.dto.MeasurementRequestDto;
import ru.maltsev.alishevcourse.restsensorapp.dto.MeasurementResponseDto;
import ru.maltsev.alishevcourse.restsensorapp.model.Measurement;

import java.time.LocalDateTime;

@Component
public class MeasurementMapper {
    private final ModelMapper modelMapper;
    public MeasurementMapper() {
        modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Measurement.class, MeasurementResponseDto.class)
                .addMappings(mapper ->
                        mapper.map(src -> src.getSensor().getName(), MeasurementResponseDto::setSensorName));
    }

    public Measurement toMeasurement(MeasurementRequestDto requestDto) {
        Measurement measurement = modelMapper.map(requestDto, Measurement.class);
        measurement.setDateTime(LocalDateTime.now());
        return measurement;
    }

    public MeasurementResponseDto toResponseDto(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementResponseDto.class);
    }
}
