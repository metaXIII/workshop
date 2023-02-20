package com.metaxiii.fr.mapstruct.config;

import com.metaxiii.fr.mapstruct.entity.ItemEntity;
import com.metaxiii.fr.mapstruct.entity.UtilityEntity;
import com.metaxiii.fr.mapstruct.repository.ItemRepository;
import com.metaxiii.fr.mapstruct.repository.UtilityRepository;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ItemRepository itemRepository, UtilityRepository utilityRepository) {
    return args -> {
      final var itemSaved = itemRepository.save(
        ItemEntity
          .builder()
          .id(1L)
          .name("my item")
          .value(10.00)
          .createdAt(LocalDateTime.now())
          .updatedAt(LocalDateTime.now())
          .build()
      );
      utilityRepository.save(UtilityEntity.builder().id(1L).values("Not usefull").item(itemSaved).build());
      itemRepository.findAll().forEach(item -> log.info("Preloaded " + item));
      utilityRepository.findAll().forEach(utility -> log.info("Preloaded " + utility));
    };
  }
}
