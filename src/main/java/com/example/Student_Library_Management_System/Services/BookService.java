package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book){

        // I want to get the Author Entity
        int authorId = book.getAuthor().getId();

        // Now I will be fetching Author Entity
        Author author = authorRepository.findById(authorId).get();
        // Do exception Handling


        // basic attributes are set from postman

        // setting the foreign key attr in the child class
        book.setAuthor(author);

        //we need to update the list of book written in the parent class
        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);



        // Now the book is to be saved, but also author is also to be saved
        // Since the author is updated. we have to update or re-save the author entity

        authorRepository.save(author);  // Date modified
        // .save function works both as saving and update

        // bookRepo is not called bcz it will be auto called because of the cascading effect



        return "Book added successfully";

    }
}
