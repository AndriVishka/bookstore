package com.tct.rest12.controller;

import com.tct.rest12.entities.Department;
import com.tct.rest12.exceptions.TCTException;
import com.tct.rest12.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveDepartment(@RequestBody Department department){
        log.info("Started saveDepartment() at {}  request body: {}", Instant.now(), department);

        service.saveDepartment(department);

        log.info("Ended saveDepartment() at {} ", Instant.now());

        return ResponseEntity.ok("Department saved successfully!!!");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Department>> getAllDepartments(){
        log.info("Started getAllDepartments() at {}", Instant.now());

        List<Department> departments=null;
        try{
            departments =service.getAll();
            log.info("Ended getAllDepartments() at {}", Instant.now());
            return ResponseEntity.ok(departments);
        } catch (TCTException t){
            log.info("Error at getAllDepartments() at {}", Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Department>getById(@PathVariable("id")Integer id){
        log.info("Started getById() at {}", Instant.now());
        Department dpt;

        try{
            dpt= service.findById(id);
            log.info("Ended getById() at {}", Instant.now());
            return ResponseEntity.ok(dpt);
        }catch (TCTException t){
            log.info("Error at getById() at {}", Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/updateDepartment")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department){
        log.info("Started updateDepartment() at{}",Instant.now());
        Integer result = null;
        try {
            result = service.updateDepartment(department);
            log.info("Ended updateDepartment() at {}",Instant.now());
            return ResponseEntity.ok("Updated succesfully");
        }catch (TCTException e){
            log.info("Error at updateDepartment() at {}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/delet")
    public ResponseEntity<String>deleteDepartment(@RequestBody Department department){
        log.info("Started deleteDepartment()at{}",Instant.now());
            service.deleteDepartment(department);
            log.info("Ended deleteDepartment()at{}",Instant.now());
        return ResponseEntity.ok("U kry");
    }
}
