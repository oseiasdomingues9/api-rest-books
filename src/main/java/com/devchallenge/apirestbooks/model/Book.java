package com.devchallenge.apirestbooks.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = -4747871727208497300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String publisher;
    private String photo;

    @ManyToMany
    private List<Author> authors = new ArrayList<>();


    public Book(Long id, String title, String publisher, String photo) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.photo = photo;
    }
}
