package com.tct.rest12.hw.controller;

import com.tct.rest12.hw.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/info")
    public ResponseEntity<User> userInfo(@RequestBody User user){
        return ResponseEntity.ok(user);
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkUser(@RequestBody User user){

        if (user.getEmail().contains("@")){
            return ResponseEntity.ok(user.toString());
        }

        return ResponseEntity.badRequest().body("Frate kujdes emailin hapi syte mire");
    }

}
