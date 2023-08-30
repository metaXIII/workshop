package com.metaxiii.fr.record.controller;

import com.metaxiii.fr.record.dao.ItemService;
import com.metaxiii.fr.record.domain.Item;
import com.metaxiii.fr.record.dto.ItemDto;
import com.metaxiii.fr.record.records.ItemRecord;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ItemController {

  private final ItemService service;

  @GetMapping("/")
  public ResponseEntity<List<Item>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @PostMapping("/1")
  public ResponseEntity<Item> save(@RequestBody final ItemDto itemDto) {
    return new ResponseEntity<>(service.save(itemDto), HttpStatus.CREATED);
  }

  @PostMapping("/2")
  public ResponseEntity<Item> save(@RequestBody final ItemRecord record) {
    return new ResponseEntity<>(service.save(record), HttpStatus.CREATED);
  }

  @PostMapping("/3")
  public ResponseEntity<ItemRecord> saveRecord(@RequestBody final ItemRecord record) {
    return new ResponseEntity<>(service.saveRecord(record), HttpStatus.CREATED);
  }

  @GetMapping("/4")
  public ResponseEntity<Item> fewerInfo() {
    return new ResponseEntity<>(service.findFewerInfoRecord(), HttpStatus.CREATED);
  }
}
