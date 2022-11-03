package com.metaxiii.fr.fakefeign.controller;

import com.metaxiii.fr.fakefeign.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        log.info(request.toString());
        final var error = new ErrorDto(403, "this is my message, you should not use 1 for id");
        return new ResponseEntity<>(
                error, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
