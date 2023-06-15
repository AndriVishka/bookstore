package com.tct.rest12.controller;

import com.tct.rest12.entities.Course;
import com.tct.rest12.exceptions.TCTException;
import com.tct.rest12.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveCourse(@RequestBody Course course){
        log.info("Started saveCourse() at {}  request body: {}", Instant.now(), course);

        service.saveCourse(course);

        log.info("Ended saveCourse() at {} ", Instant.now());

        return ResponseEntity.ok("Course saved successfully!!!");
    }

    @GetMapping("/getCoursesByStudentId")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@RequestParam("id") Integer id){
        log.info("Started getCoursesByStudentId() at {} request body: {} ", Instant.now(), id);

        try {
            List<Course> list = service.getCoursesByStudentId(id);
            log.info("Ended getCoursesByStudentId() at {} ", Instant.now());

            return ResponseEntity.ok(list);
        } catch (TCTException e) {
            log.info("Ended getCoursesByStudentId() in ERROR at {} ", Instant.now());

            return ResponseEntity.notFound().build();
        }
    }
}
