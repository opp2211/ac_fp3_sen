package ru.maltsev.alishevcourse.restsensorapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.maltsev.alishevcourse.restsensorapp.dto.ErrorResponse;
import ru.maltsev.alishevcourse.restsensorapp.exceptions.NotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AdviceExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    private ErrorResponse handleMethArgNotValid(MethodArgumentNotValidException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .dateTime(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    private ErrorResponse handleNotFound(NotFoundException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .dateTime(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
