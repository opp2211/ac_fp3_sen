package ru.maltsev.alishevcourse.restsensorapp.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsev.alishevcourse.restsensorapp.dto.SensorRequestDto;
import ru.maltsev.alishevcourse.restsensorapp.mapper.SensorMapper;
import ru.maltsev.alishevcourse.restsensorapp.services.SensorService;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {
    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Valid SensorRequestDto sensorDto) {
        sensorService.addNew(sensorMapper.toSensor(sensorDto));
    }
}
