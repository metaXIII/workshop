package com.metaxiii.fr.fakefeign.controller;

import com.metaxiii.fr.fakefeign.dto.ErrorDto;
import com.metaxiii.fr.fakefeign.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDto> handleAccessDeniedException(
            CustomException exception) {
        log.error(exception.getMessage());
        final var details = exception.getDetails();
        if (details == null) {
            return ResponseEntity.status(500).body(new ErrorDto(500, exception.getMessage()));
        }
        final var errorDto = new ErrorDto(details.getCodeStatus(), exception.getMessage());
        return ResponseEntity.status(details.getCodeStatus()).body(errorDto);
    }
}
