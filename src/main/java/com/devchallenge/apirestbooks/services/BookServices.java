package com.devchallenge.apirestbooks.services;

import com.devchallenge.apirestbooks.model.Book;
import com.devchallenge.apirestbooks.repository.BookRepository;
import com.devchallenge.apirestbooks.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Book insert(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Long id, Book newBook){
        Book oldBook = bookRepository.getById(id);
        updateDate(oldBook,newBook);
        return bookRepository.save(oldBook);
    }

    private void updateDate(Book oldBook, Book newBook) {
        oldBook.setTitle(newBook.getTitle());
        oldBook.setPublisher(newBook.getPublisher());
        oldBook.setPhoto(newBook.getPhoto());
        oldBook.setAuthors(newBook.getAuthors());
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
