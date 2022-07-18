package com.armapp.controller;

import com.armapp.model.*;
import com.armapp.repository.CategoryRepository;
import com.armapp.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ReqController {

    private IRequestService iRequestService;
    private CategoryRepository categoryRepo;

    @Autowired
    public void setiRequestService(IRequestService iRequestService) {
        this.iRequestService = iRequestService;
    }

    @Autowired
    public void setCategoryRepo(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @GetMapping("/create_req")
    @RolesAllowed("manager")
    public void save() {
        Request request = new Request();
        request.setRequestId(123456);
        request.setPriority(Priority.HIGH.toString());
        request.setUnionName(Union.DAG.name());
        request.setStatus(Status.COMPLETED.name());
        request.setProductionName("Test");
        request.setTalentName("Test");
        request.setProductionNumber("P12345");
        request.setProjectName("Test");
        request.setRequestCreatedDate(LocalDate.now());
        request.setAuditStartDate(LocalDate.now());
        request.setAuditEndDate(LocalDate.now());
        request.setContractDate(LocalDate.now());
        request.setCreatedBy("Test");
        request.setCreatedAt(LocalDateTime.now());


        RequestSchedule schedule = new RequestSchedule();
        schedule.setRequestScheduleId(12345);
        schedule.setRequestCreated(LocalDate.now());
        schedule.setExpectedClosure(LocalDate.now());
        schedule.setCreatedBy("Test");
        schedule.setRequest(request);
        schedule.setCreatedAt(LocalDateTime.now());
        request.setRequestSchedule(schedule);

        Category category = categoryRepo.findById(2003).get();
        Task task = new Task();
        task.setTaskId(123);
        task.setCreatedAt(LocalDateTime.now());
        task.setCreatedBy("Test");
        task.setCategory(category);
        task.setRequest(request);
        Set<Task> tasks = new HashSet<>();
        tasks.add(task);
        request.setTasksList(tasks);
        iRequestService.save(request);

    }

    @GetMapping("/req/{userId}")
    ResponseEntity<List<Request>> getAllRequests(@PathVariable String userId){
        List<Request> requests = iRequestService.findByAssignedUserId(userId);
        return ResponseEntity.ok(requests);
    }
}
