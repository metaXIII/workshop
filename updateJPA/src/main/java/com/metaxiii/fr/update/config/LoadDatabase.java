package com.metaxiii.fr.update.config;

import com.metaxiii.fr.update.entity.Item;
import com.metaxiii.fr.update.repository.ItemRepository;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ItemRepository itemRepository) {
    return args -> {
      itemRepository.save(
        Item
          .builder()
          .id(1L)
          .name("my item")
          .value(10.00)
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build()
      );
      itemRepository.findAll().forEach(item -> log.info("Preloaded " + item));
    };
  }
}
