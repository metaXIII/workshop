package com.metaxiii.fr.webmvctest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("hello");
    }
}
