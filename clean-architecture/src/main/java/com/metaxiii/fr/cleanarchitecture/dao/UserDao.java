package com.metaxiii.fr.cleanarchitecture.dao;

import com.metaxiii.fr.cleanarchitecture.domain.User;

public interface UserDao {
  User findByFirstNameContainsIgnoreCase(String userName);
}
