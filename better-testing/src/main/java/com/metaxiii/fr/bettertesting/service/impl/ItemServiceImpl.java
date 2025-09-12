package com.metaxiii.fr.bettertesting.service.impl;

import com.metaxiii.fr.bettertesting.domain.Item;
import com.metaxiii.fr.bettertesting.entity.ItemEntity;
import com.metaxiii.fr.bettertesting.enums.StatusEnum;
import com.metaxiii.fr.bettertesting.mapper.ItemMapper;
import com.metaxiii.fr.bettertesting.repository.ItemRepository;
import com.metaxiii.fr.bettertesting.service.ItemService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemMapper itemMapper;
  private final ItemRepository itemRepository;

  @Override
  public List<Item> shopAllItems() {
    return itemRepository.findAll().stream().filter(ItemEntity::isAvailable).map(itemMapper::toDomain).toList();
  }
}
