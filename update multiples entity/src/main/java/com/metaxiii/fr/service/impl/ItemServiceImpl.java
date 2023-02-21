package com.metaxiii.fr.service.impl;

import com.metaxiii.fr.entity.ItemEntity;
import com.metaxiii.fr.repository.ItemRepository;
import com.metaxiii.fr.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    @Override
    public List<ItemEntity> findAll() {
        return repository.findAll();
    }
}
