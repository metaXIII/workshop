package com.metaxiii.fr.fakefeign.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

@RestController
public class HelloController {
    @GetMapping
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("welcome");
    }

    @GetMapping("{id}")
    ResponseEntity<String> showException(@PathVariable(name = "id") String id) throws Exception {
        if (id.equals("1"))
            throw new AccessDeniedException("not allowed id with 1");
        return ResponseEntity.ok("it's called");
    }
}
