package com.metaxiii.fr.bettertesting.mapper;

import com.metaxiii.fr.bettertesting.domain.Item;
import com.metaxiii.fr.bettertesting.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper {
  Item toDomain(ItemEntity entity);
}
