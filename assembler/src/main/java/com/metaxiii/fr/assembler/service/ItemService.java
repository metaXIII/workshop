package com.metaxiii.fr.assembler.service;

import com.metaxiii.fr.assembler.domain.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item save(Item item);

    Item findById(long i);
}
