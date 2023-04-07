package com.metaxiii.fr.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql(scripts = "classpath:/data.sql")
@ComponentScan(basePackages = "com.metaxiii.fr")
class ItemServiceImplTest {
  @Autowired
  private ItemServiceImpl service;

  @Test
  void itShouldFindAll() {
    assertEquals(6, service.findAll().size());
  }
}
