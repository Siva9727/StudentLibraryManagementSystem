package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    private int pages;

    @Getter
    @Setter
    private Genre genre;



    //here comes the mapping part
    //first check who is the parent class. here author is the parent class
    // set foreign key : there are standard three steps.

    @ManyToOne
    @JoinColumn //add an extra attribute of authorId(parent table Primary Key) for the foreign key of child table
    //add getters and setters
    @Getter
    @Setter
    private Author author; // this is the parent entity we are connecting with


    // Book is a child wrt Card entity
    // so mapping
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn
    private Card card;


    public Book() {
    }
}
