package com.metaxiii.fr.bettertesting.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.metaxiii.fr.bettertesting.enums.StatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan(value = "com.metaxiii.fr.bettertesting")
class ItemServiceImplTest {

  @Autowired
  private ItemServiceImpl itemService;

  /*
    query generated:
    select ie1_0.id,ie1_0.description,ie1_0.is_available,ie1_0.name,ie1_0.status
    from item_entity ie1_0
    where ie1_0.is_available
   */
  @Test
  void itShouldShopAllItems() {
    final var items = itemService.shopAllItems();
    assertEquals(2, items.size());
    final var firstItem = items.getFirst();
    final var lastItem = items.getLast();
    assertEquals(2, firstItem.id());
    assertEquals("PC Gaming", firstItem.name());
    assertEquals("A powerful computer", firstItem.description());
    assertEquals(StatusEnum.NEW, firstItem.status());
    assertEquals(true, firstItem.isAvailable());
    assertEquals(3, lastItem.id());
    assertEquals("RG3S", lastItem.name());
    assertEquals("A portable console for retro gaming", lastItem.description());
    assertEquals(StatusEnum.NEW, firstItem.status());
    assertEquals(true, firstItem.isAvailable());
  }
}
