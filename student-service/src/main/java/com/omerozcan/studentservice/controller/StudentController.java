package com.omerozcan.studentservice.controller;

import com.omerozcan.studentservice.model.Student;
import com.omerozcan.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping
    public Student add(@RequestBody Student student){
        return studentRepository.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student geyById(@PathVariable Long id){
        return studentRepository.findById(id);
    }

    @GetMapping
    public List<Student> findAll(){
        return studentRepository.findAll();
    }


}
