package com.devchallenge.apirestbooks.repository;

import com.devchallenge.apirestbooks.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
