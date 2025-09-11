package com.metaxiii.fr.bettertesting.controller;

import com.metaxiii.fr.bettertesting.assembler.ItemAssembler;
import com.metaxiii.fr.bettertesting.model.ItemModel;
import com.metaxiii.fr.bettertesting.service.ItemService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ItemController {

  private final ItemAssembler assembler;
  private final ItemService itemService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ItemModel>> shopItems() {
    return ResponseEntity.status(HttpStatus.OK).body(
      itemService.shopAllItems().stream().map(assembler::toModel).toList()
    );
  }
}
