package com.devchallenge.apirestbooks.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
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

    @OneToMany
    private List<Author> authors = new ArrayList<>();

}
