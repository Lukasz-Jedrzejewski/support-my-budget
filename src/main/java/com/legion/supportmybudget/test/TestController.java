package com.legion.supportmybudget.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/")
@RestController
public class TestController {

    private final Tess tess;
    private final ReceiptMapper mapper;

    public TestController(Tess tess, ReceiptMapper mapper) {
        this.tess = tess;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<String> testAction(@RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(tess.doOcr(file));
    }

    @PostMapping("/db")
    public ResponseEntity<String> testDb(@RequestBody Receipt receipt) {
        mapper.insert(receipt);
        return ResponseEntity.ok("Success");
    }

    @GetMapping
    public List<Receipt> getAll() {
        return mapper.findAll();
    }
}
