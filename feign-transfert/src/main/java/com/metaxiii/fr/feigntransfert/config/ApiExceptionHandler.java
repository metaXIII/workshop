package com.metaxiii.fr.feigntransfert.config;

import com.metaxiii.fr.feigntransfert.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        log.info(request.toString());
        final var error = new ErrorDto(404, ex.getCause().getMessage());
        return new ResponseEntity<>(
                error, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
