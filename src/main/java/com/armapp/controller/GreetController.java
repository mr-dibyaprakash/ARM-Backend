package com.armapp.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class GreetController {

    @GetMapping("/greet")
    @RolesAllowed({"user","admin"})
    ResponseEntity<String> greet()  {
        return ResponseEntity.ok().headers(httpHeaders -> httpHeaders.add("desc","greet message"))
                .body("Have a Good Day");
    }
}
