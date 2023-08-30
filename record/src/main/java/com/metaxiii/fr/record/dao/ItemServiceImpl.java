package com.metaxiii.fr.record.dao;

import com.metaxiii.fr.record.domain.Item;
import com.metaxiii.fr.record.dto.ItemDto;
import com.metaxiii.fr.record.mapper.ItemMapper;
import com.metaxiii.fr.record.records.FewerInfoRecord;
import com.metaxiii.fr.record.records.ItemRecord;
import com.metaxiii.fr.record.repository.ItemRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;
  private final ItemMapper mapper;

  @Override
  public List<Item> findAll() {
    return itemRepository.findAll().stream().map(mapper::toDomain).toList();
  }

  @Override
  public Item findFewerInfoRecord() {
    return itemRepository.findById(1L, FewerInfoRecord.class).map(mapper::toDomain).orElseThrow();
  }

  @Override
  public Item save(final ItemDto itemDto) {
    return mapper.toDomain(itemRepository.save(mapper.toEntity(itemDto)));
  }

  @Override
  public Item save(final ItemRecord record) {
    return mapper.toDomain(itemRepository.save(mapper.toEntity(record)));
  }

  @Override
  public ItemRecord saveRecord(final ItemRecord record) {
    return mapper.toRecord(itemRepository.save(mapper.toEntity(record)));
  }
}
