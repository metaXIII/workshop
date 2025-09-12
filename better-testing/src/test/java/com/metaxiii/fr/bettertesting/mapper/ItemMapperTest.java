package com.metaxiii.fr.bettertesting.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.metaxiii.fr.bettertesting.entity.ItemEntity;
import com.metaxiii.fr.bettertesting.enums.StatusEnum;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class ItemMapperTest {

  private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

  @Test
  void itShouldToDomain() {
    final var entity = new ItemEntity();
    entity.setId(1L);
    entity.setName("Item 1");
    entity.setDescription("Description 1");
    entity.setStatus(StatusEnum.NEW);
    entity.setIsAvailable(true);
    final var result = itemMapper.toDomain(entity);
    assertNotNull(result);
    assertEquals(entity.getId(), result.id());
    assertEquals(entity.getName(), result.name());
    assertEquals(entity.getDescription(), result.description());
    assertEquals(entity.getStatus(), result.status());
    assertEquals(entity.getIsAvailable(), result.isAvailable());
  }
}
