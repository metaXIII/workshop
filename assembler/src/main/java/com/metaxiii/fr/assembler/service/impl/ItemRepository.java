package com.metaxiii.fr.assembler.service.impl;

import com.metaxiii.fr.assembler.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {}
