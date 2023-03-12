package com.metaxiii.testquery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestQueryApplicationTest {

  @Test
  void main() {
    assertDoesNotThrow(() -> TestQueryApplication.main(new String[] {}));
  }
}
