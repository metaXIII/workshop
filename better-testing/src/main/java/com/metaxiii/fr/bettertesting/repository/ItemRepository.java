package com.metaxiii.fr.bettertesting.repository;

import com.metaxiii.fr.bettertesting.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {}
