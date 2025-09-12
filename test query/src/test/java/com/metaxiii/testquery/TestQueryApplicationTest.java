package com.metaxiii.testquery;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestQueryApplicationTest {

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> TestQueryApplication.main(new String[] {}));
  }
}
