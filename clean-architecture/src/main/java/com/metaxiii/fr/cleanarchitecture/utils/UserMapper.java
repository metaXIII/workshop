package com.metaxiii.fr.cleanarchitecture.utils;

import com.metaxiii.fr.cleanarchitecture.domain.User;
import com.metaxiii.fr.cleanarchitecture.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toDomain(UserEntity entity) {
    return new User(
      entity.getId(),
      entity.getFirstName(),
      entity.getLastName(),
      entity.getUsername(),
      entity.getPassword(),
      entity.getEmail(),
      entity.getPhone()
    );
  }
}
