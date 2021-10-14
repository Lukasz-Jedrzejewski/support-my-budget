package com.legion.supportmybudget.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/")
@RestController
public class TestController {

    private final Tess tess;

    public TestController(Tess tess) {
        this.tess = tess;
    }

    @PostMapping
    public ResponseEntity<String> testAction(@RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(tess.doOcr(file));
    }
}
