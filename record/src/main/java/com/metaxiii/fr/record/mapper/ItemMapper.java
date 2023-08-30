package com.metaxiii.fr.record.mapper;

import com.metaxiii.fr.record.domain.Item;
import com.metaxiii.fr.record.dto.ItemDto;
import com.metaxiii.fr.record.entity.ItemEntity;
import com.metaxiii.fr.record.records.FewerInfoRecord;
import com.metaxiii.fr.record.records.ItemRecord;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ItemMapper {
  Item toDomain(ItemEntity item);

  Item toDomain(FewerInfoRecord r);

  ItemEntity toEntity(ItemDto itemDto);

  ItemEntity toEntity(ItemRecord record);

  ItemRecord toRecord(ItemEntity save);
}
