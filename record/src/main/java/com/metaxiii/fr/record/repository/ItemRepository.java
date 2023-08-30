package com.metaxiii.fr.record.repository;

import com.metaxiii.fr.record.entity.ItemEntity;
import com.metaxiii.fr.record.records.FewerInfoRecord;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
  <T> Optional<T> findById(long id, Class<T> tClass);
}
