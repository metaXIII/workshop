package com.metaxiii.fr.exceptiontesting.exception;

import java.text.MessageFormat;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private final transient ErrorCodeDetails details;

  public CustomException(final ErrorCodeDetails details, Object... params) {
    super(MessageFormat.format(details.getMessage(), params));
    this.details = details;
  }
}
