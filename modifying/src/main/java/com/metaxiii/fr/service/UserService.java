package com.metaxiii.fr.service;

import com.metaxiii.fr.entity.User;
import com.metaxiii.fr.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {
  private final UserRepository repository;

  public boolean isItWorkWithoutFlushing() {
    final var john = repository.findById(1L).orElse(null);
    if (john != null) {
      john.setActive(false);
      repository.save(john); //not yet
      repository.deleteInActiveUsers();
      // long behavior but eventually we need to delete him
      //then we have to find all user for whatever reason
    }
    return findIfJohnExist();
  }

  public boolean findIfJohnExist() {
    //then we have to find all user for whatever reason
    User exist = repository.findById(1L).orElse(null);
    if (exist != null) {
      log.error("not deletedYet");
      return true;
    }
    return false;
  }

  public boolean isItWorkWithoutClearing() {
    repository.findById(1L).ifPresent(user -> repository.deleteUser());
    if (repository.findById(1L).isPresent()) {
      return true;
    }
    return false;
  }
}
