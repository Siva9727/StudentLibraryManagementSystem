package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
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

    public String addBook(BookRequestDto bookRequestDto){

        // I want to get the Author Entity
        int authorId = bookRequestDto.getAuthorId();

        // Now I will be fetching Author Entity
        Author author = authorRepository.findById(authorId).get();

        // BookDTO to book entity
        Book book=new Book();

        // basic attributes should be set from bookDto to book entity
        book.setName(bookRequestDto.getName());
        book.setGenre(bookRequestDto.getGenre());
        book.setPages(bookRequestDto.getPages());
        book.setIssued(false);





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
