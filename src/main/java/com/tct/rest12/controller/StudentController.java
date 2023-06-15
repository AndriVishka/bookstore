package com.tct.rest12.controller;

import com.tct.rest12.entities.Student;
import com.tct.rest12.exceptions.TCTException;
import com.tct.rest12.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Student student){

        service.saveStudent(student);

        return ResponseEntity.ok("Student saved successfully");
    }


    @GetMapping("/find/{name}")
    ResponseEntity<Student> findByName(@PathVariable("name") String name) {

        log.info("Started Request at {}, request name: {}", Instant.now(), name);

        try {
                Student student = service.findStudentByName(name);

            log.info("Ended Request at {}, response : {}", Instant.now(), student);

            return ResponseEntity.ok(student);
        }
        catch (TCTException e){

            log.error("Ended Request at {}, Exception handled for : {}", Instant.now(), e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){

        long started = Instant.now().toEpochMilli();

        log.info("StudentController.getAllStudents() Started Request at {}", Instant.now());

        List<Student> list=null;

        try {
             list = service.getAllStudents();

            log.info("StudentController.getAllStudents()  Ended Request in {}", Instant.now().toEpochMilli()-started);

            return  ResponseEntity.ok(list);
        } catch (TCTException e) {

            log.error("StudentController.getAllStudents() Ended Error Request in {} ", Instant.now().toEpochMilli()-started);
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }


    @GetMapping("/getStudentById")
    public ResponseEntity<Student> getStudentById (@RequestParam ("id") Integer studentId) {

        log.info("StudentController.getById() Started Request at {}", Instant.now());

        Student student = null;
        try{ student = service.getStudentById(studentId);
            log.info("StudentController.getById() Ended Request at {}", Instant.now());
            return ResponseEntity.ok(student);
        } catch (TCTException e){
            log.error("StudentController.getById() Error at {}", Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        try {
            service.updateStudent(student);
            log.info("StudentController.updateStudent() Ended Request at {}", Instant.now());
            return ResponseEntity.ok("Student updated succesfully");
        }catch (TCTException e){
            log.error("Error Student Not Found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") Integer id){
        service.deleteStudent(id);
        return ResponseEntity.ok("Deleted succesfully"); 
    }

    @GetMapping("/getStudentsByCourseId")
    public ResponseEntity<List<Student>>getStudentsByCourseId(@RequestParam("id") Integer id){
        log.info("Started getStudentsByCourseId at {} , request body: {}", Instant.now(),id);
        List<Student> list;
        try{
            list = service.getStudentsByCourseId(id);
            log.info("Ended getStudentsByCourseId at {} , request body: {}", Instant.now(),id);
            return ResponseEntity.ok(list);
        } catch (TCTException t){
            log.info("Error at getStudentsByCourseId at {} , request body: {}", Instant.now(),id);
            return ResponseEntity.notFound().build();
        }

    }

}
