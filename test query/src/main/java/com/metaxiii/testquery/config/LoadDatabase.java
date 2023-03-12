package com.metaxiii.testquery.config;

import com.metaxiii.testquery.entity.StuffEntity;
import com.metaxiii.testquery.repository.StuffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(StuffRepository repository) {
    return args -> {
      int i = 0;
      while (i < 60000) {
        repository.save(new StuffEntity((long) i, "_" + i));
        i++;
      }
    };
  }
}
