package ru.maltsev.alishevcourse.restsensorapp.validator.sensor_name;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SensorNameValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SensorNameNotExist {
    String message() default "Sensor with such name is already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
