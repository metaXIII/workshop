package com.metaxiii.fr.java1721;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Java1721ApplicationTests {

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> Java1721Application.main(new String[] {}));
  }
}
