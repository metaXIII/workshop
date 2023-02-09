package com.metaxiii.fr.update.controller;

import com.metaxiii.fr.update.entity.Item;
import com.metaxiii.fr.update.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/item")
public class ItemController {
  private final ItemService itemService;

  @PatchMapping("/1")
  public ResponseEntity<Item> updateJPAEntity() {
    final var name = "my new name for unexisting DTO";
    final var value = 12.24;
    return new ResponseEntity<>(itemService.updateNameAndValueByItemId(name, value, 1L), HttpStatus.OK);
  }

  @PatchMapping("/2")
  public ResponseEntity<Void> updateWithQuery() {
    final var name = "newest my new name for unexisting DTO";
    final var value = 24.12;
    itemService.updateNameAndValueByItemIdReturningVoid(name, value, 1L);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
