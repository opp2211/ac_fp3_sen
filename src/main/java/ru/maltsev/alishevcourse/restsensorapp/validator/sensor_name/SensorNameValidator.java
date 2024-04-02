package ru.maltsev.alishevcourse.restsensorapp.validator.sensor_name;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import ru.maltsev.alishevcourse.restsensorapp.repositories.SensorRepository;

public class SensorNameValidator implements ConstraintValidator<SensorNameNotExist, String> {

    @Autowired
    private SensorRepository sensorRepository; // Bad practice
    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return !sensorRepository.existsByName(s);
    }
}
