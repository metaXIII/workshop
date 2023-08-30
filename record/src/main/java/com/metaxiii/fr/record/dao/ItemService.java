package com.metaxiii.fr.record.dao;

import com.metaxiii.fr.record.domain.Item;
import com.metaxiii.fr.record.dto.ItemDto;
import com.metaxiii.fr.record.records.ItemRecord;
import java.util.List;

public interface ItemService {
  List<Item> findAll();

  Item findFewerInfoRecord();

  Item save(ItemDto itemDto);

  Item save(ItemRecord record);

  ItemRecord saveRecord(ItemRecord record);
}
