package com.metaxiii.fr.exceptiontesting;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExceptionTestingApp.class)
class ExceptionTestingAppTest {

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> ExceptionTestingApp.main(new String[] {}));
  }
}
