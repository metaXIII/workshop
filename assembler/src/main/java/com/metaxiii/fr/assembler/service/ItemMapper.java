package com.metaxiii.fr.assembler.service;

import com.metaxiii.fr.assembler.domain.Item;
import com.metaxiii.fr.assembler.entity.ItemEntity;

import java.util.List;

public interface ItemMapper {
    Item toDomain(ItemEntity item);

    List<Item> toDomain(List<ItemEntity> items);

    ItemEntity toEntity(Item item);
}
