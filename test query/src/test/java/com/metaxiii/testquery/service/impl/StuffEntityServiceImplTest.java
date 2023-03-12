package com.metaxiii.testquery.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.metaxiii.testquery.service.StuffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan(basePackages = "com.metaxiii.testquery")
class StuffEntityServiceImplTest {
  @Autowired
  private StuffService stuffService;

  @Test
  void findAllBySQL() {
    assertDoesNotThrow(() -> stuffService.findAllBySQL());
  }

  @Test
  void findAllByJPA() {
    assertDoesNotThrow(() -> stuffService.findAllByJPA());
  }

  @Test
  void compare() {
    assertDoesNotThrow(() -> stuffService.compare());
  }
}
