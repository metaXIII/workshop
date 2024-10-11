package com.metaxiii.fr.cleanarchitecture.service;

import com.metaxiii.fr.cleanarchitecture.domain.User;
import com.metaxiii.fr.cleanarchitecture.domain.UserRight;
import com.metaxiii.fr.cleanarchitecture.utils.Tuple2;

public interface UserService {
  Tuple2<User, UserRight> findByUserName(String userName);
}
