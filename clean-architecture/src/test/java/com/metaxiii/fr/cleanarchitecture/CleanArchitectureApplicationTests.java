package com.metaxiii.fr.cleanarchitecture;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CleanArchitectureApplicationTests {

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> CleanArchitectureApplication.main(new String[] {}));
  }
}
