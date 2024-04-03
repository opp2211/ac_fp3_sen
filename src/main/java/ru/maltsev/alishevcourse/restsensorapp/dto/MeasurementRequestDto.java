package ru.maltsev.alishevcourse.restsensorapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MeasurementRequestDto {
    @NotNull
    @Min(-100)
    @Max(100)
    private Double value; // Значение температуры воздуха

    @NotNull
    private Boolean raining;

    @NotNull
    private SensorRequestDto sensor;
}
