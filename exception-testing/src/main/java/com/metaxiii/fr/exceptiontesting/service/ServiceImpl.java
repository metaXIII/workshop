package com.metaxiii.fr.exceptiontesting.service;

import com.metaxiii.fr.exceptiontesting.exception.CustomErrorCode;
import com.metaxiii.fr.exceptiontesting.exception.CustomException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl {

  public void doSomething(final String id) {
    if (id.equals("test with custom error code")) {
      throw new CustomException(CustomErrorCode.NOT_DEFAULT_MESSAGE, id);
    } else {
      log.info("Hello !!! The provided id {} is allowed", id);
    }
  }
}
