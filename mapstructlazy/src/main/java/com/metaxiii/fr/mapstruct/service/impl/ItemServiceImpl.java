package com.metaxiii.fr.mapstruct.service.impl;

import com.metaxiii.fr.mapstruct.entity.ItemEntity;
import com.metaxiii.fr.mapstruct.mapper.UtilityMapper;
import com.metaxiii.fr.mapstruct.model.Utility;
import com.metaxiii.fr.mapstruct.repository.ItemRepository;
import com.metaxiii.fr.mapstruct.repository.UtilityRepository;
import com.metaxiii.fr.mapstruct.service.ItemService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
  private final ItemRepository repository;
  private final UtilityRepository utilityRepository;
  private final UtilityMapper utilityMapper;

  @Override
  public ItemEntity updateNameAndValueByItemId(String name, double value, long id) {
    final var item = repository.getReferenceById(id);
    item.setName(name);
    item.setValue(value);
    item.setUpdatedAt(LocalDateTime.now());
    return repository.save(item);
  }

  @Override
  public void updateNameAndValueByItemIdReturningVoid(String name, double value, long id) {
    repository.updateNameAndValueAndUpdatedAtByIdReturningVoid(name, value, id);
  }

  @Override
  public Utility getMapper() {
    return utilityMapper.toDomain(utilityRepository.findById(1L).orElse(null));
  }

  @Override
  public Utility getMapperLazy() {
    return utilityMapper.toDomainLazy(utilityRepository.findById(1L).orElse(null));
  }
}
