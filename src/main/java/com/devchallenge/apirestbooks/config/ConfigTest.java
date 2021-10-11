package com.devchallenge.apirestbooks.config;


import com.devchallenge.apirestbooks.model.Author;
import com.devchallenge.apirestbooks.model.Book;
import com.devchallenge.apirestbooks.repository.AuthorRepository;
import com.devchallenge.apirestbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ConfigTest implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {


        Author author01 = new Author(null,"Carlos");
        Author author02 = new Author(null,"Luiz");

        authorRepository.saveAll(Arrays.asList(author01,author02));

        Book book01 = new Book(null, "Harry Potter", "Intrinseca", "loremIpsum");
        Book book02 = new Book(null, "Harry Potter 2", "Intrinseca", "loremIpsum");
        Book book03 = new Book(null, "Harry Potter 3 ", "Intrinseca", "loremIpsum");

        bookRepository.saveAll(Arrays.asList(book01,book02,book03));

        author01.getBooks().add(book01);
        author02.getBooks().add(book01);
        author01.getBooks().add(book02);
        author02.getBooks().add(book03);


        authorRepository.saveAll(Arrays.asList(author01,author02));

        book01.getAuthors().add(author01);
        book01.getAuthors().add(author02);
        book02.getAuthors().add(author01);
        book03.getAuthors().add(author02);

        bookRepository.saveAll(Arrays.asList(book01,book02,book03));

    }
}
