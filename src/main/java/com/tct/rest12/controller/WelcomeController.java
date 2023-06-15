package com.tct.rest12.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {

    @GetMapping
    public ResponseEntity<String> homepage(Principal auth){
        return ResponseEntity.ok("WELCOME "+auth.getName()+ " TO TCT WEBAPP");
    }
}
