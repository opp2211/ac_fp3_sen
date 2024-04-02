package ru.maltsev.alishevcourse.restsensorapp.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.maltsev.alishevcourse.restsensorapp.validator.sensor_name.SensorNameNotExist;

@Data
public class SensorRequestDto {
    @SensorNameNotExist
    @Size(min = 3, max = 30, message = "Название сенсора должно находится в пределах 3-30 символов")
    private String name;
}
