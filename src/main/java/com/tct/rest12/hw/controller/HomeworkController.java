package com.tct.rest12.hw.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tct/homework")
public class HomeworkController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){

        return ResponseEntity.ok("Hello World");
    }


}
