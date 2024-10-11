package com.metaxiii.fr.cleanarchitecture.repository;

import com.metaxiii.fr.cleanarchitecture.entity.UserRightEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRightRepository extends JpaRepository<UserRightEntity, Long> {
  Optional<UserRightEntity> findByUserId(long id);
}
