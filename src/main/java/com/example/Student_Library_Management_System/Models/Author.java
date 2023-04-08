package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    private double rating;

    //this  is the annotation we are writing in the parent class
    //part of the bidirectional mapping
    @Getter
    @Setter
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksWritten = new ArrayList<>();;

    public Author() {

    }
}
