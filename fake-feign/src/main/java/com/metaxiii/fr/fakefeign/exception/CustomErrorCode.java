package com.metaxiii.fr.fakefeign.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CustomErrorCode implements ErrorCodeDetails{
    DEFAULT_MESSAGE("not allowed id", 400),
    NOT_DEFAULT_MESSAGE("not allowed id with {0}", 400);

    private final String message;
    private final int codeStatus;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getCodeStatus() {
        return codeStatus;
    }
}
