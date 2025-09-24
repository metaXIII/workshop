package com.metaxiii.fr.controller;

import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class HeroRepository {

  public static final List<HeroEntity> HEROES = new ArrayList<>();

  public List<HeroEntity> findAll() {
    return HEROES;
  }

  public HeroEntity findById(long l) {
    return HEROES.stream()
      .filter(hero -> hero.getId() == l)
      .findFirst()
      .orElse(null);
  }
}
