package com.metaxiii.fr.exceptiontesting.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CustomErrorCode implements ErrorCodeDetails {
  DEFAULT_MESSAGE("not allowed id", 403, "TECHNICAL"),
  NOT_DEFAULT_MESSAGE("not allowed id with {0}", 400, "FUNCTIONAL");

  private final String message;
  private final int codeStatus;
  private final String level;

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public int getCodeStatus() {
    return codeStatus;
  }

  @Override
  public String getLevel() {
    return level;
  }
}
