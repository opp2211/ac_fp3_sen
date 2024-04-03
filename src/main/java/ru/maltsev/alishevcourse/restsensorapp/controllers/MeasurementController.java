package ru.maltsev.alishevcourse.restsensorapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsev.alishevcourse.restsensorapp.dto.MeasurementRequestDto;
import ru.maltsev.alishevcourse.restsensorapp.mapper.MeasurementMapper;
import ru.maltsev.alishevcourse.restsensorapp.services.MeasurementService;

@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor
public class MeasurementController {
    private final MeasurementService measurementService;
    private final MeasurementMapper measurementMapper;

    @PostMapping("/add")
    public void addNew(@RequestBody @Valid MeasurementRequestDto measurementDto) {
        measurementService.addNew(measurementMapper.toMeasurement(measurementDto), measurementDto.getSensor().getName());
    }
}
