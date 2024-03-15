package com.omerozcan.lessonservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.omerozcan.lessonservice.client.StudentClient;
import com.omerozcan.lessonservice.model.Lesson;
import com.omerozcan.lessonservice.producer.LessonProducer;
import com.omerozcan.lessonservice.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private LessonProducer lessonProducer;

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

    @PostMapping("/notification")
    public ResponseEntity<Lesson> postLessonEvent(@RequestBody Lesson lesson) throws JsonProcessingException {
        lessonProducer.sendLessonTopic(lesson);
        return ResponseEntity.status(HttpStatus.CREATED).body(lesson);
    }
}
