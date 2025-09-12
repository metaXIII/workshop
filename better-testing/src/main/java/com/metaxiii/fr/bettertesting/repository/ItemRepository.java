package com.metaxiii.fr.bettertesting.repository;

import com.metaxiii.fr.bettertesting.entity.ItemEntity;
import java.nio.channels.FileChannel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
  List<ItemEntity> findAllByIsAvailableTrue();
}
