package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {


    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){


    }
}
