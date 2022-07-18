package com.armapp.controller;

import com.armapp.model.Task;
import com.armapp.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private ITaskService iTaskService;

    @GetMapping("/tasks")
    @RolesAllowed("report_owner")
    List<Task> getAllTasks() {
        List<Task> tasks = iTaskService.findAll();
        return tasks;
    }
}
