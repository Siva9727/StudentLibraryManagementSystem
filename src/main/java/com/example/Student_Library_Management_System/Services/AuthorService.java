package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    // to get the author entity to create author, im autowiring the entity from repo
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        // Imp step
        // the obj is of type DTO but the repo interact only with entity

        // soln: convert authorDTO to author entity

        // we have created an obj of type author
        Author author = new Author();

        // we are setting its attributes so that we can save correct values in db
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);

        return "Author added successfully";

    }
}
