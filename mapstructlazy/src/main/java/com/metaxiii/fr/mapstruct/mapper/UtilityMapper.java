package com.metaxiii.fr.mapstruct.mapper;

import com.metaxiii.fr.mapstruct.entity.UtilityEntity;
import com.metaxiii.fr.mapstruct.model.Utility;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  uses = ItemMapper.class
)
public interface UtilityMapper {
  Utility toDomain(UtilityEntity entity);

  @Mapping(target = "item", ignore = true)
  Utility toDomainLazy(UtilityEntity entity);
}
