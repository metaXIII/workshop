package com.metaxiii.fr.feigntransfert.controller;

import com.metaxiii.fr.feigntransfert.service.client.FakeClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class Controller {
  private final FakeClient fakeClient;

  @GetMapping("/")
  public ResponseEntity<String> hello() {
    log.info("call fake");
    return fakeClient.getHello();
  }

  @GetMapping("{id}")
  public ResponseEntity<String> sayError(@PathVariable(name = "id") String id) {
    log.info("call for error");
    return fakeClient.getError(id);
  }
}
