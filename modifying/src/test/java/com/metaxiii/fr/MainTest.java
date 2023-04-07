package com.metaxiii.fr;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainTest {

  @Test
  void itShouldMain() {
    assertDoesNotThrow(() -> Main.main(new String[] {}));
  }
}
