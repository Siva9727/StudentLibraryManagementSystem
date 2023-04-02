package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    }
}
