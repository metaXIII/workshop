package com.metaxiii.fr.fakefeign.controller;

import com.metaxiii.fr.fakefeign.exception.CustomErrorCode;
import com.metaxiii.fr.fakefeign.exception.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiExceptionHandlerTest {
    private ApiExceptionHandler apiExceptionHandler;

    @BeforeEach
    void init() {
        this.apiExceptionHandler = new ApiExceptionHandler();
    }

    @Test
    void handleAccessDeniedException() {
        final var exceptionWithMessage = new CustomException("there is a new custom " +
                "exception");
        final var exceptionWithErrorCodeDetails = new CustomException(CustomErrorCode.DEFAULT_MESSAGE);
        final var exceptionWithErrorCodeDetailsFormat = new CustomException(CustomErrorCode.NOT_DEFAULT_MESSAGE, 2);
        assertDoesNotThrow(() -> {
            final var objectResponseEntity =
                    apiExceptionHandler.handleAccessDeniedException(exceptionWithMessage);
            assertEquals(500, objectResponseEntity.getStatusCodeValue());
        });
        assertDoesNotThrow(() -> {
            final var response = apiExceptionHandler.handleAccessDeniedException(exceptionWithErrorCodeDetails);
            assertEquals(400, response.getStatusCodeValue());
            assertEquals("not allowed id", Objects.requireNonNull(response.getBody()).getMessage());
        });
        assertDoesNotThrow(() -> {
            final var response = apiExceptionHandler.handleAccessDeniedException(exceptionWithErrorCodeDetailsFormat);
            assertEquals(400, response.getStatusCodeValue());
            assertEquals("not allowed id with 2", Objects.requireNonNull(response.getBody()).getMessage());
        });

    }
}
