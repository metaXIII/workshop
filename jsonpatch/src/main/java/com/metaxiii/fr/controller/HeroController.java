package com.metaxiii.fr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HeroController {

  private final HeroRepository heroRepository;
  private final ObjectMapper objectMapper;

  @GetMapping("/")
  public ResponseEntity<List<HeroEntity>> getAllHeroes() {
    return ResponseEntity.status(HttpStatus.OK).body(heroRepository.findAll());
  }

  @PatchMapping(value = "/", consumes = "application/json-patch+json")
  public ResponseEntity<String> patchItem(@RequestBody final JsonPatch jsonPatch)
    throws JsonPatchException, JsonProcessingException {
    final var superman = heroRepository.findById(1L);
    final HeroEntity heroEntity = applyPatchToCustomer(jsonPatch, superman);
    return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(heroEntity));
  }

  private HeroEntity applyPatchToCustomer(final JsonPatch patch, final HeroEntity targetHero)
    throws JsonPatchException, JsonProcessingException {
    final JsonNode patched = patch.apply(objectMapper.convertValue(targetHero, JsonNode.class));
    return objectMapper.treeToValue(patched, HeroEntity.class);
  }
}
