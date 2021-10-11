package com.devchallenge.apirestbooks.services;

import com.devchallenge.apirestbooks.model.Author;
import com.devchallenge.apirestbooks.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServices {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }

    public Author insert(Author author) {
        return authorRepository.save(author);
    }


}
