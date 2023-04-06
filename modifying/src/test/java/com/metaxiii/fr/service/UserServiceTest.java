package com.metaxiii.fr.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

@DataJpaTest
@ComponentScan(basePackages = "com.metaxiii.fr")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTest {
  @Autowired
  private UserService userService;

  @Test
  void itShouldIsItWorkWithoutFlushing() {
    assertTrue(userService.isItWorkWithoutFlushing());
  }

  @Test
  void itShouldWorkWithoutClearContext() {
    assertTrue(userService.isItWorkWithoutClearing());
  }
}
