package com.metaxiii.fr.cleanarchitecture.controller;

import com.metaxiii.fr.cleanarchitecture.assembler.UserAssembler;
import com.metaxiii.fr.cleanarchitecture.model.UserModel;
import com.metaxiii.fr.cleanarchitecture.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserAssembler assembler;
  private final UserService userService;

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserModel> findUser() {
    return ResponseEntity.status(HttpStatus.OK).body(assembler.toFindUser(userService.findByUserName("user")));
  }
  //List right of users 1
}
