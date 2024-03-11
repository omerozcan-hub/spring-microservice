package com.omerozcan.lessonservice.controller;

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


}
