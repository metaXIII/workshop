package com.metaxiii.testquery.service.impl;

import com.metaxiii.testquery.entity.StuffEntity;
import com.metaxiii.testquery.repository.StuffRepository;
import com.metaxiii.testquery.service.StuffService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class StuffServiceImpl implements StuffService {
  private final StuffRepository repository;

  @Override
  public List<StuffEntity> findAllBySQL() {
    long start = System.currentTimeMillis();
    List<StuffEntity> sql = repository.findAllBySQL();
    long finish = System.currentTimeMillis();
    log.warn((finish - start) + "milli secondes");
    return sql;
  }

  @Override
  public List<StuffEntity> findAllByJPA() {
    long start = System.currentTimeMillis();
    List<StuffEntity> sql = repository.findAllByJPA();
    long finish = System.currentTimeMillis();
    log.warn((finish - start) + "milli secondes");
    return sql;
  }

  @Override
  public void compare() {
    long startSQL = System.currentTimeMillis();
    List<StuffEntity> sql = repository.findAllByJPA();
    System.out.println(sql.size());
    long finish = System.currentTimeMillis();
    long durationOfSQL = finish - startSQL;
    long startJPA = System.currentTimeMillis();
    List<StuffEntity> jpa = repository.findAllByJPA();
    System.out.println(jpa.size());
    finish = System.currentTimeMillis();
    long durationOfJPA = finish - startJPA;
    if (durationOfJPA < durationOfSQL) {
      log.error("SQL is not better than JPA");
    }
  }
}
