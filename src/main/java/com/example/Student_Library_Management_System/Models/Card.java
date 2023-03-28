package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp // automatically saves the time of creation
    Date createdOn;

    @UpdateTimestamp  // sets time when an entry is updated
    Date updatedOn;

    public Card() {
    }
}
