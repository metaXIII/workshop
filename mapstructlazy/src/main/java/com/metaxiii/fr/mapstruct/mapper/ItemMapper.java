package com.metaxiii.fr.mapstruct.mapper;

import com.metaxiii.fr.mapstruct.entity.ItemEntity;
import com.metaxiii.fr.mapstruct.model.Item;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ItemMapper {
  Item toDomain(ItemEntity entity);
}
