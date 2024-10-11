package com.metaxiii.fr.cleanarchitecture.dao;

import com.metaxiii.fr.cleanarchitecture.domain.UserRight;

public interface UserRightDao {
  UserRight findByUserId(long id);
}
