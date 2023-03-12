package com.metaxiii.testquery.service;

import com.metaxiii.testquery.entity.StuffEntity;
import java.util.List;

public interface StuffService {
  List<StuffEntity> findAllBySQL();

  List<StuffEntity> findAllByJPA();

  void compare();
}
