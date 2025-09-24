package com.metaxiii.fr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaxiii.fr.controller.HeroEntity;
import com.metaxiii.fr.controller.HeroRepository;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPatchesJson {

  public static void main(final String[] args) {
    SpringApplication.run(SpringBootPatchesJson.class, args);
  }

  @Bean
  public CommandLineRunner init() {
    return args -> {
      HeroRepository.HEROES.clear();
      final var mapper = new ObjectMapper();
      final Map<String, List<String>> supermanAttributes = new HashMap<>();
      supermanAttributes.put("power", Arrays.asList("Speed", "Strength, Flight"));
      supermanAttributes.put("weaknesses", List.of("Kryptonite", "Lois Lane"));
      final var superman = new HeroEntity(1L, "Superman", mapper.valueToTree(supermanAttributes));
      final var batmanAttributes = new HashMap<>();
      batmanAttributes.put("power", List.of("Combat, Intelligence, Wealth"));
      batmanAttributes.put("weaknesses", List.of("None"));
      final var batman = new HeroEntity(2L, "Batman", mapper.valueToTree(batmanAttributes));
      HeroRepository.HEROES.add(superman);
      HeroRepository.HEROES.add(batman);
    };
  }
}
