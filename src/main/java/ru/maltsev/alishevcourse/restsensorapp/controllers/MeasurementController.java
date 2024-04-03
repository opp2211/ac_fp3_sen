package ru.maltsev.alishevcourse.restsensorapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.maltsev.alishevcourse.restsensorapp.dto.MeasurementRequestDto;
import ru.maltsev.alishevcourse.restsensorapp.dto.MeasurementResponseDto;
import ru.maltsev.alishevcourse.restsensorapp.mapper.MeasurementMapper;
import ru.maltsev.alishevcourse.restsensorapp.services.MeasurementService;

import java.util.Collection;
import java.util.stream.Collectors;

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

    @GetMapping
    public Collection<MeasurementResponseDto> getAll() {
        return measurementService.getAll().stream()
                .map(measurementMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/rainyCount")
    public int getRainyCount() {
        return measurementService.getRainyCount();
    }

    @GetMapping("/rainyDaysCount")
    public int getRainyDaysCount() {
        return measurementService.getRainyDaysCount();
    }
}
