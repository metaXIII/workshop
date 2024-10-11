package com.metaxiii.fr.cleanarchitecture.dao.impl;

import com.metaxiii.fr.cleanarchitecture.dao.UserRightDao;
import com.metaxiii.fr.cleanarchitecture.domain.UserRight;
import com.metaxiii.fr.cleanarchitecture.repository.UserRightRepository;
import com.metaxiii.fr.cleanarchitecture.utils.UserRightMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserRightDaoImpl implements UserRightDao {

  private final UserRightRepository repository;
  private final UserRightMapper mapper;

  @Override
  public UserRight findByUserId(final long id) {
    return repository.findByUserId(id).map(mapper::toDomain).orElse(null);
  }
}
