package com.example.taleadventure.base.advice;

import com.example.taleadventure.base.dto.ApiExceptionResponse;
import com.example.taleadventure.base.error.exception.TaleAdventureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(TaleAdventureException.class)
    public ResponseEntity<ApiExceptionResponse> handleBaseException(TaleAdventureException exception){
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(exception.getStatus()).body(ApiExceptionResponse.error(exception.getResult()));
    }
}
