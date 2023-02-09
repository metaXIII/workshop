package com.metaxiii.fr.update.repository;

import com.metaxiii.fr.update.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
  @Transactional
  @Modifying(clearAutomatically = true, flushAutomatically = true)
  @Query("update Item i set i.name = ?1, i.value = ?2, i.updatedAt = now() where i.id = ?3")
  void updateNameAndValueAndUpdatedAtByIdReturningVoid(String name, double value, Long id);
}
