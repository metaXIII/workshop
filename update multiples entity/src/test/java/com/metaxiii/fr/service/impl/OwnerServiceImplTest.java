package com.metaxiii.fr.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql(scripts = "classpath:/data.sql")
@ComponentScan(basePackages = "com.metaxiii.fr")
@Slf4j
class OwnerServiceImplTest {
  @Autowired
  private OwnerServiceImpl service;

  @Test
  void itShouldFindAll() {
    final var all = service.findAll();
    assertEquals(4, all.size());
    assertEquals("myself", all.get(0).getName());
    assertEquals(1, all.get(0).getId());
    assertEquals(6, all.get(0).getItems().size());
    assertEquals("SG", all.get(0).getCompany().getName());
  }

  @Test
  void itShouldSaveWithError() {
    final var projection = service.findById(1L);
    assertEquals(1, projection.getId());
    assertEquals("myself", projection.getName());
    projection.setName("new name");
    final var result = service.save(projection);
    assertEquals(1, result.getId());
    assertEquals("new name", result.getName());
    try {
      assertEquals("DO NOT UPDATE THESE FIELD", result.getDoNotUpdate());
      assertEquals("SG", result.getCompany().getName());
      assertEquals(6, result.getItems().size());
    } catch (AssertionFailedError e) {
      log.error(e.getMessage());
      log.error("whoopsie, we update a value that we did not want to update");
    }
  }

  @Test
  void itShouldSaveOnlyOwner() {
    final var projection = service.findById(1L);
    assertEquals(1, projection.getId());
    assertEquals("myself", projection.getName());
    projection.setName("new name");
    final var result = service.partialSave(projection);
    assertEquals(1, result.getId());
    assertEquals("new name", result.getName());
    assertEquals("DO NOT UPDATE THESE FIELD", result.getDoNotUpdate());
    assertEquals("SG", result.getCompany().getName());
    assertEquals(6, result.getItems().size());
  }
}
