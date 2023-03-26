package com.metaxiii.testquery.repository;

import com.metaxiii.testquery.entity.StuffEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffRepository extends JpaRepository<StuffEntity, Long> {
  @Query(value = "select * from stuff", nativeQuery = true)
  List<StuffEntity> findAllBySQL();

  @Query(value = "select s from StuffEntity s")
  List<StuffEntity> findAllByJPA();
}
