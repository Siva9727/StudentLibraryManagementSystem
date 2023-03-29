package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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

    @Enumerated(value = EnumType.STRING) // since sql don't understand enums. this annotation converts enums to string
    @Getter
    @Setter
    private CardStatus cardStatus;

    public Card() {
    }

    // unidirectional relation
    @OneToOne
    @JoinColumn
    @Getter
    @Setter
    Student studentVariableName;



}
