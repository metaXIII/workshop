package com.metaxiii.fr.fakefeign.exception;

import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCodeDetails details;

    public CustomException(final String customMessage) {
        super(customMessage);
        this.details = null;
    }

    public CustomException(final ErrorCodeDetails details) {
        super(details.getMessage());
        this.details = details;
    }

    public CustomException(final ErrorCodeDetails details, Object... params) {
        super(MessageFormat.format(details.getMessage(), params));
        this.details = details;
    }
}
