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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author implements Serializable {

    private static final long serialVersionUID = -4747871727208497300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
