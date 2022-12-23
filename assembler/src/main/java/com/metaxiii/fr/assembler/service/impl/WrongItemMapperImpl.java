package com.metaxiii.fr.assembler.service.impl;

import com.metaxiii.fr.assembler.domain.Item;
import com.metaxiii.fr.assembler.entity.ItemEntity;
import com.metaxiii.fr.assembler.service.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WrongItemMapperImpl implements ItemMapper {
    @Override
    public Item toDomain(final ItemEntity item) {
        return Item
                .builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .build();
    }

    @Override
    public List<Item> toDomain(final List<ItemEntity> items) {
        return items
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public ItemEntity toEntity(final Item item) {
        final var entity = new ItemEntity();
        entity.setId(item.getId());
        entity.setName(item.getName());
        entity.setPrice(item.getPrice());
        return entity;
    }
}
