package com.metaxiii.fr.bettertesting;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BetterTestingApplicationTests {

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> BetterTestingApplication.main(new String[] {}));
  }
}
