package com.metaxiii.fr.exceptiontesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.metaxiii.fr.exceptiontesting.exception.CustomException;
import org.junit.jupiter.api.Test;

class ServiceImplTest {

  private final ServiceImpl service = new ServiceImpl();

  @Test
  void itShouldDoSomethingFinal() {
    final var errorFunctional = assertThrows(CustomException.class, () ->
      service.doSomething("test with custom error code")
    );
    assertEquals("not allowed id with test with custom error code", errorFunctional.getMessage());
    assertEquals("FUNCTIONAL", errorFunctional.getDetails().getLevel());
    assertEquals("not allowed id with {0}", errorFunctional.getDetails().getMessage());
    assertEquals(400, errorFunctional.getDetails().getCodeStatus());
  }
}
