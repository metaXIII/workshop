package com.metaxiii.fr.repository;

import com.metaxiii.fr.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
    <T> T findById(long id, Class<T> type);
}
