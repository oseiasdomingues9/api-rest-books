package com.devchallenge.apirestbooks.config;


import com.devchallenge.apirestbooks.model.Author;
import com.devchallenge.apirestbooks.model.Book;
import com.devchallenge.apirestbooks.repository.AuthorRepository;
import com.devchallenge.apirestbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ConfigTest implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        Author author01 = new Author(null,"Leandro Karnal");
        Author author02 = new Author(null,"Mário Sergio Cortella");
        Author author03 = new Author(null,"Luiz Felipe Pondé");

        authorRepository.saveAll(Arrays.asList(author01,author02,author03));


        Book book01 = new Book(null, "Felicidade: Modos de usar", "Planeta", "https://images-na.ssl-images-amazon.com/images/I/41PB2pWLi8L._SX322_BO1,204,203,200_.jpg");
        Book book02 = new Book(null, "Viver, a que se destina?", "Papirus 7 Mares", "https://images-na.ssl-images-amazon.com/images/I/41zWAj3KXHL._SX331_BO1,204,203,200_.jpg");
        Book book03 = new Book(null, "A coragem da esperança ", "Planeta", "https://images-na.ssl-images-amazon.com/images/I/51izFAEAQbS._SY344_BO1,204,203,200_QL70_ML2_.jpg");

        bookRepository.saveAll(Arrays.asList(book01,book02,book03));

        author01.getBooks().add(book01);
        author01.getBooks().add(book02);
        author01.getBooks().add(book03);

        author02.getBooks().add(book01);
        author02.getBooks().add(book02);

        author03.getBooks().add(book01);

        authorRepository.saveAll(Arrays.asList(author01,author02,author03));


        book01.getAuthors().add(author01);
        book01.getAuthors().add(author02);
        book01.getAuthors().add(author03);

        book02.getAuthors().add(author01);
        book02.getAuthors().add(author02);

        book03.getAuthors().add(author01);

        bookRepository.saveAll(Arrays.asList(book01,book02,book03));

    }

    /*EXCEPETIONS*/
}
