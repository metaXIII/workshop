package com.metaxiii.fr.bettertesting.assembler;

import com.metaxiii.fr.bettertesting.domain.Item;
import com.metaxiii.fr.bettertesting.model.ItemModel;
import org.springframework.stereotype.Component;

@Component
public class ItemAssembler {

  public ItemModel toModel(final Item item) {
    return new ItemModel(item.name(), item.description(), item.isAvailable());
  }
}
