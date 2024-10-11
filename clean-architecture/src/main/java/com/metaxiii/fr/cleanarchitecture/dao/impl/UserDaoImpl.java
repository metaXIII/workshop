package com.metaxiii.fr.cleanarchitecture.dao.impl;

import com.metaxiii.fr.cleanarchitecture.dao.UserDao;
import com.metaxiii.fr.cleanarchitecture.domain.User;
import com.metaxiii.fr.cleanarchitecture.repository.UserRepository;
import com.metaxiii.fr.cleanarchitecture.utils.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDaoImpl implements UserDao {

  private final UserRepository repository;
  private final UserMapper mapper;

  @Override
  public User findByFirstNameContainsIgnoreCase(final String userName) {
    return repository.findByFirstNameContainsIgnoreCase(userName).map(mapper::toDomain).orElse(null);
  }
}
