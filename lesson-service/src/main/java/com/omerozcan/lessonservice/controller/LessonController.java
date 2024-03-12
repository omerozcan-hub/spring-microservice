package com.omerozcan.lessonservice.controller;

import com.omerozcan.lessonservice.client.StudentClient;
import com.omerozcan.lessonservice.model.Lesson;
import com.omerozcan.lessonservice.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private StudentClient studentClient;

    @PostMapping
    public Lesson add(@RequestBody Lesson lesson){
        return lessonRepository.addLesson(lesson);
    }

    @GetMapping("/{id}")
    public Lesson geyById(@PathVariable Long id){
        return lessonRepository.findById(id);
    }

    @GetMapping
    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    @GetMapping("/with-students")
    public List<Lesson> findAllWithStudents(){
        List<Lesson> lessonList = lessonRepository.findAll();

        lessonList.forEach(c -> c.setStudentList(studentClient.findByLessonId(c.getId())));

        return lessonList;
    }

}
