package com.devchallenge.apirestbooks.repository;

import com.devchallenge.apirestbooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
