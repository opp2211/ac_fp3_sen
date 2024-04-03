package ru.maltsev.alishevcourse.restsensorapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeasurementResponseDto {
    private Integer id;

    private Double value;

    private Boolean raining;

    private String sensorName;

    private LocalDateTime dateTime;
}
