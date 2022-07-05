package com.armapp.controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetController {

    @GetMapping("/greet")
    ResponseEntity<String> getByBrand()  {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Greet Message");
        return ResponseEntity.ok().headers(headers).body("Have a Good Start");

    }
}
