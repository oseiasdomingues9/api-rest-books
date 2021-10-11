package com.devchallenge.apirestbooks.controller;

import com.devchallenge.apirestbooks.model.Author;
import com.devchallenge.apirestbooks.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    AuthorServices authorServices;

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        List<Author> list = authorServices.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        Author author = authorServices.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }

    @PostMapping
    public ResponseEntity<Author> findById(@RequestBody Author obj) {
        Author author = authorServices.insert(obj);
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }
}
