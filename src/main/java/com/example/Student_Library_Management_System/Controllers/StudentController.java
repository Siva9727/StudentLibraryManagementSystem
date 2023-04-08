package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    //to add the student
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    // get student by email
    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email")String email){
        return studentService.getNameByEmail(email);
    }

    @PutMapping("/update_mob")
    public String updateMobNo(@RequestBody StudentUpdateMobRequestDto studentReqDto){
        return studentService.updateMobNo(studentReqDto);
    }


}
