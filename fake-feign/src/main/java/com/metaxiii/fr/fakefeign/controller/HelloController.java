package com.metaxiii.fr.fakefeign.controller;

import com.metaxiii.fr.fakefeign.exception.CustomErrorCode;
import com.metaxiii.fr.fakefeign.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping
  ResponseEntity<String> hello() {
    return ResponseEntity.ok("welcome");
  }

  @GetMapping("{id}")
  ResponseEntity<String> showException(@PathVariable(name = "id") String id) {
    if (id.equals("1")) {
      throw new CustomException(CustomErrorCode.DEFAULT_MESSAGE);
    }
    if (id.equals("2")) {
      throw new CustomException(CustomErrorCode.NOT_DEFAULT_MESSAGE, 2);
    }
    if (id.equals("3")) {
      throw new CustomException("custom message here");
    }
    return ResponseEntity.ok("it's called");
  }
}
