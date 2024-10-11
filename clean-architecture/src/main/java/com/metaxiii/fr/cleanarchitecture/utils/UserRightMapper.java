package com.metaxiii.fr.cleanarchitecture.utils;

import com.metaxiii.fr.cleanarchitecture.domain.UserRight;
import com.metaxiii.fr.cleanarchitecture.entity.UserRightEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserRightMapper {

  private final UserMapper userMapper;

  public UserRight toDomain(final UserRightEntity entity) {
    return new UserRight(entity.getId(), userMapper.toDomain(entity.getUser()), entity.getRights());
  }
}
