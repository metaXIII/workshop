package com.metaxiii.fr.repository;

import com.metaxiii.fr.entity.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Transactional
  @Modifying
  @Query("delete User u where u.active = false")
  void deleteInActiveUsers();

  @Transactional
  @Modifying
  @Query("delete User u where u.id = 1")
  void deleteUser();

  @Query(value = "select * from user_entity", nativeQuery = true)
  List<User> findAll();

  @Query(value = " select * from user_entity where active = true", nativeQuery = true)
  List<User> findNativeQuery();
}
