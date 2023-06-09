package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
public class Student {
    @Id // primary key set.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generate id.
    @Getter // lombok annotation
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Column(unique = true) // email address will be unique.
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String mobNo;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String country;

    // for Bi-directional relation
    // name of the variable of the parent entity that you have written in child class
    @OneToOne(mappedBy = "studentVariableName",cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Card card;

    public Student() {
    }
}
