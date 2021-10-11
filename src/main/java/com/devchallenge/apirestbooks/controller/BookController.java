package com.devchallenge.apirestbooks.controller;

import com.devchallenge.apirestbooks.model.Book;
import com.devchallenge.apirestbooks.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
@Api(value = "API REST - Library")
public class BookController {

    @Autowired
    BookServices bookServices;

    @ApiOperation(value = "List all books")
    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = bookServices.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @ApiOperation(value = "Find books by id")
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = bookServices.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
    @ApiOperation(value = "Insert a product")
    @PostMapping
    public ResponseEntity<Book> findById(@RequestBody Book obj){
        Book book = bookServices.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @ApiOperation(value = "Updates a product")
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id,@RequestBody Book book){
        Book entity = bookServices.update(id, book);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @ApiOperation(value = "Delete a product")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
