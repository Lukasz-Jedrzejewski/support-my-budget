package com.legion.supportmybudget.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class TestController {

    @GetMapping
    public ResponseEntity<String> testAction() {
        return ResponseEntity.ok("Hello!");
    }
}
