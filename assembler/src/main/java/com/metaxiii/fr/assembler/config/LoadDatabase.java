package com.metaxiii.fr.assembler.config;

import com.metaxiii.fr.assembler.entity.ItemEntity;
import com.metaxiii.fr.assembler.service.impl.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository) {
        return args -> {
            final var price = 10.00;
            final var name = "random name ";
            for (int i = 0; i < 6; i++) {
                final var entity = new ItemEntity();
                entity.setId(i + 1);
                entity.setName(name + i);
                entity.setPrice(price + ((i + 1) * 5.14));
                itemRepository.save(entity);
            }
        };
    }
}
