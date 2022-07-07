/**
 * @Author:Awadhesh
 * @Date:05-07-2022
 * @Time:23:13
 * @Project Name:Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
package com.armapp.controller;

import com.armapp.model.User;
import com.armapp.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private DummyService dummyService;

    @GetMapping()
    @RolesAllowed("admin")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(dummyService.getAll());
    }


    @GetMapping("/{id}")
    @RolesAllowed("user")
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(dummyService.getUser(id));
    }
}
