package com.metaxiii.fr.cleanarchitecture.repository;

import com.metaxiii.fr.cleanarchitecture.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  @Query("""
      select u
      from UserEntity u
      where upper(u.firstName) like upper(concat('%', ?1, '%'))""")
  Optional<UserEntity> findByFirstNameContainsIgnoreCase(String firstName);
}
