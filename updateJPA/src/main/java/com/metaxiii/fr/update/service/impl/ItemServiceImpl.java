package com.metaxiii.fr.update.service.impl;

import com.metaxiii.fr.update.entity.Item;
import com.metaxiii.fr.update.repository.ItemRepository;
import com.metaxiii.fr.update.service.ItemService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
  private final ItemRepository repository;

  @Override
  public Item updateNameAndValueByItemId(String name, double value, long id) {
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
}
