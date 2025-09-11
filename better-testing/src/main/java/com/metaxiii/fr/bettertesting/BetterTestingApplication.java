package com.metaxiii.fr.bettertesting;

import com.metaxiii.fr.bettertesting.entity.ItemEntity;
import com.metaxiii.fr.bettertesting.enums.StatusEnum;
import com.metaxiii.fr.bettertesting.repository.ItemRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class BetterTestingApplication {

  public static void main(final String[] args) {
    SpringApplication.run(BetterTestingApplication.class, args);
  }

  @Bean
  CommandLineRunner initDatabase(final ItemRepository itemRepository) {
    return args -> {
      final var item1 = new ItemEntity();
      item1.setId(1L);
      item1.setName("Nintendo Switch");
      item1.setDescription("A hybrid console");
      item1.setStatus(StatusEnum.NEW);
      item1.setAvailable(false);
      final var item2 = new ItemEntity();
      item2.setId(2L);
      item2.setName("PC Gaming");
      item2.setDescription("A powerful computer");
      item2.setStatus(StatusEnum.NEW);
      item2.setAvailable(true);
      final var item3 = new ItemEntity();
      item3.setId(3L);
      item3.setName("RG3S");
      item3.setDescription("A portable console for retro gaming");
      item3.setStatus(StatusEnum.USED);
      item3.setAvailable(true);
      itemRepository.saveAll(List.of(item1, item2, item3));
      log.warn("Database initialized at {}", LocalDateTime.now());
      log.warn("{} items saved", itemRepository.findAll().size());
    };
  }
}
