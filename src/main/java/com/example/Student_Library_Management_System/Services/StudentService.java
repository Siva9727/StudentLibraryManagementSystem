package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    //auto-wire the student repository
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student){
        // student from postman already set the basic attributes

        //card should be auto generated when create student function is called
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);

        card.setStudentVariableName(student);  // foreign key attribute

        // let's check student
        student.setCard(card);

        // if there was uni-directional mapping. Then we have to save both of them.
        // However, we are using bidirectional mapping.Child will automatically saved
        studentRepository.save(student);
        // By cascading effect, Child will automatically get saved


        return "Student and card added";
    }
}
