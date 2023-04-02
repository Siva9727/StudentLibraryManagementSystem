package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @CreationTimestamp // automatically saves the time of creation
    Date createdOn;

    @Getter
    @Setter
    @UpdateTimestamp  // sets time when an entry is updated
    Date updatedOn;

    @Enumerated(value = EnumType.STRING) // since sql don't understand enums. this annotation converts enums to string
    @Getter
    @Setter
    private CardStatus cardStatus;



    // unidirectional relation
    @OneToOne
    @JoinColumn
    @Getter
    @Setter
    Student studentVariableName;

    // map wrt book entity
    // here card is parent and start bidirectional relationship
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksIssued;


    public Card() {
        booksIssued = new ArrayList<>();
    }
}
