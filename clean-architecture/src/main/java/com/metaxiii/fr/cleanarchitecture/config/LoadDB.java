package com.metaxiii.fr.cleanarchitecture.config;

import com.metaxiii.fr.cleanarchitecture.entity.UserEntity;
import com.metaxiii.fr.cleanarchitecture.entity.UserRightEntity;
import com.metaxiii.fr.cleanarchitecture.repository.UserRepository;
import com.metaxiii.fr.cleanarchitecture.repository.UserRightRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadDB {

  @Bean
  public CommandLineRunner commandLineRunner(
    final UserRepository userRepository,
    final UserRightRepository userRightRepository
  ) {
    return args -> {
      final var user1 = new UserEntity();
      user1.setId(1L);
      user1.setUsername("admin");
      user1.setPassword("admin");
      user1.setEmail("admin@admin.com");
      user1.setFirstName("admin First Name");
      user1.setLastName("admin Last Name");
      final var user2 = new UserEntity();
      user2.setId(2L);
      user2.setUsername("user");
      user2.setPassword("user");
      user2.setEmail("user@admin.com");
      user2.setFirstName("user First Name");
      user2.setLastName("user Last Name");
      final var userRight1 = new UserRightEntity();
      userRight1.setId(1L);
      userRight1.setRights("adminstator, console");
      userRight1.setUser(user1);
      final var userRight2 = new UserRightEntity();
      userRight2.setId(2L);
      userRight2.setRights("console, regular");
      userRight2.setUser(user2);
      userRepository.saveAll(List.of(user1, user2));
      userRightRepository.saveAll(List.of(userRight1, userRight2));
      log.info("Users saved");
      log.info("Debug : ");
      log.info(userRepository.findAll().toString());
      log.info(userRightRepository.findAll().toString());
    };
  }
}
