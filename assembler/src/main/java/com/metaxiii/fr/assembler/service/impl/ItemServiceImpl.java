package com.metaxiii.fr.assembler.service.impl;

import com.metaxiii.fr.assembler.domain.Item;
import com.metaxiii.fr.assembler.service.ItemMapper;
import com.metaxiii.fr.assembler.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemMapper mapper;
    private final ItemRepository repository;

    @Override
    public List<Item> findAll() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public Item save(final Item item) {
        return mapper.toDomain(repository.save(mapper.toEntity(item)));
    }

    @Override
    public Item findById(final long id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }
}
