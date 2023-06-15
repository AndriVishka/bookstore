package com.tct.rest12.hw.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ints")
public class IntegersController {

    @PostMapping("/avg")
    public ResponseEntity<Double> average(@RequestBody List<Integer> list){
        double avg = list.stream()
                .mapToDouble(Integer::doubleValue)
                .average().getAsDouble();
        return ResponseEntity.ok(avg) ;
    }

    /*
    Create a REST API that gets a list of ints as input in any order
    and returns the list in ascending order.
     */

    @PostMapping("/sort")
    public ResponseEntity<List<Integer>> list(@RequestBody List<Integer> list2){
       list2 = list2.stream().sorted().collect(Collectors.toList());
       return ResponseEntity.ok(list2);
    }
}
