package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Data
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int fine;

    private String transactionId = UUID.randomUUID().toString();

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssueOperation;

    // for the mapping btw book(parent)
    @ManyToOne
    @JoinColumn
    private Book book;


    // Similarly we also wanted to connect with card
    @ManyToOne
    @JoinColumn
    private Card card;

}
