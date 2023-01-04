package com.metaxiii.fr.assembler.controller;

import com.metaxiii.fr.assembler.assembler.ItemAssembler;
import com.metaxiii.fr.assembler.creator.ItemCreator;
import com.metaxiii.fr.assembler.domain.Item;
import com.metaxiii.fr.assembler.dto.ItemInput;
import com.metaxiii.fr.assembler.dto.NameInputDTO;
import com.metaxiii.fr.assembler.model.ItemModel;
import com.metaxiii.fr.assembler.model.SecondModelAskedByEmmanuel;
import com.metaxiii.fr.assembler.service.ItemService;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ItemController {
    private final ItemCreator creator;
    private final ItemService itemService;
    private final ItemAssembler assembler;
    private final Validator validator;

    @GetMapping("/")
    public ResponseEntity<List<Item>> findItemsWrongWay() {
        final var items = itemService.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/1")
    public ResponseEntity<List<ItemModel>> findItems() {
        final var list = itemService.findAll()
                .stream()
                .map(assembler::toModel)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/2")
    public ResponseEntity<List<SecondModelAskedByEmmanuel>> findItemsAskedByEmmanuel() {
        final var list = itemService.findAll()
                .stream()
                .map(assembler::otherModel)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ItemModel> createItem(@Valid @RequestBody ItemInput input) {
        return new ResponseEntity<>(
                assembler.toModel(
                        itemService.save(
                                creator.toDomain(input))), HttpStatus.CREATED); //creator to convert to domain
    }

    @PatchMapping("/")
    public ResponseEntity<ItemModel> createItem(@Valid @RequestBody NameInputDTO dto) {
        this.validateDTO(dto);
        final var item = itemService.findById(1);
        item.setName(dto.getName());
        return new ResponseEntity<>(assembler.toModel(itemService.save(item)), HttpStatus.ACCEPTED);
    }

    private void validateDTO(final NameInputDTO dto) {
        final var constraintViolations = validator.validate(dto);
        //we can also use
        final var violations = validator.validateProperty(dto, "name");
        if (!constraintViolations.isEmpty() || !violations.isEmpty()) {
            log.error("there are errors");
        }
    }
}
