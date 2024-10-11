package com.metaxiii.fr.cleanarchitecture.service.impl;

import com.metaxiii.fr.cleanarchitecture.dao.UserDao;
import com.metaxiii.fr.cleanarchitecture.dao.UserRightDao;
import com.metaxiii.fr.cleanarchitecture.domain.User;
import com.metaxiii.fr.cleanarchitecture.domain.UserRight;
import com.metaxiii.fr.cleanarchitecture.service.UserRightService;
import com.metaxiii.fr.cleanarchitecture.service.UserService;
import com.metaxiii.fr.cleanarchitecture.utils.Tuple2;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRightService userRightService;
  private final UserDao userDao;
  private final UserRightDao userRightDao;

  @Override
  public Tuple2<User, UserRight> findByUserName(final String userName) {
    final User user = userDao.findByFirstNameContainsIgnoreCase(userName);
    final var userRights = userRightDao.findByUserId(user.id());
    return new Tuple2<>(user, userRights);
  }
}
