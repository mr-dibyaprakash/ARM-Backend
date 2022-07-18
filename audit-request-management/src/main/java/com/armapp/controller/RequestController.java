package com.armapp.controller;

import com.armapp.model.*;
import com.armapp.repository.CategoryRepository;
import com.armapp.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author - Akash Kanaparthi
 * @date - 12-07-2022
 * @project - AUDIT-REQUEST-MANAGEMENT_BE
 */
@RestController
@RequestMapping("/api")
public class RequestController {

    private CategoryRepository categoryRepository;
    private IRequestService requestService;
    @Autowired
    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }
    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param request
     * @return
     */
    @PostMapping("/requests")
    @RolesAllowed("manager")
    ResponseEntity<String> createRequest(@RequestBody Request request){

        Request request1 = new Request();
        request1.setRequestId(request.getRequestId());
        request1.setPriority(request.getPriority());
        request1.setUnionName(request.getUnionName());
        request1.setStatus(request.getStatus());
        request1.setProductionName(request.getProductionName());
        request1.setTalentName(request.getTalentName());
        request1.setProductionNumber(request.getProductionNumber());
        request1.setProjectName(request.getProjectName());
        request1.setRequestCreatedDate(request.getRequestCreatedDate());
        request1.setAuditStartDate(request.getAuditStartDate());
        request1.setAuditEndDate(request.getAuditEndDate());
        request1.setContractDate(request.getContractDate());
        request1.setCreatedBy(System.getProperty("user.name"));
        request1.setCreatedAt(LocalDateTime.now());

        RequestSchedule requestSchedule = request.getRequestSchedule();
        requestSchedule.setCreatedBy(request.getCreatedBy());
        requestSchedule.setCreatedAt(LocalDateTime.now());
        requestSchedule.setRequest(request1);

        Set<Task> tasksList = request.getTasksList();

        Set<Task> taskSet = new HashSet<>();
        Category category;
        Category categoryById;
        for (Task task1: tasksList){
            Task task = new Task();
            category = task1.getCategory();
            categoryById = categoryRepository.findById(category.getCategoryId()).get();
            task.setRequest(request1);
            task.setCategory(categoryById);
            task.setCreatedAt(LocalDateTime.now());
            task.setCreatedBy(request.getCreatedBy());
            taskSet.add(task);
        }
        request1.setTasksList(taskSet);
        request1.setRequestSchedule(requestSchedule);
        requestService.addRequest(request1);
        return ResponseEntity.status(HttpStatus.OK).body("Created Request");
    }

    @PutMapping("/update_requests")
    @RolesAllowed("manager")
    ResponseEntity<String> updateRequest(@RequestBody Request request){
//        Request request1 = new Request();
//        request1.setRequestId(request.getRequestId());
//        request1.setPriority(request.getPriority());
//        request1.setUnionName(request.getUnionName());
//        request1.setStatus(request.getStatus());
//        request1.setCreatedBy(request.getCreatedBy());
//        request1.setCreatedAt(request.getCreatedAt());
//        request.setUpdatedBy(request.getUpdatedBy());
        request.setUpdatedAt(LocalDateTime.now());
//
//        RequestSchedule requestSchedule = request.getRequestSchedule();
//        requestSchedule.setUpdatedBy(request.getUpdatedBy());
//        requestSchedule.setUpdatedAt(LocalDateTime.now());
//        requestSchedule.setRequest(request);
////
//        request.setRequestSchedule(requestSchedule);
        requestService.updateRequest(request);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Request");
    }

    @PutMapping("delete-req/{id}")
    @RolesAllowed("manager")
    ResponseEntity<String> deleteReq(@PathVariable("id") int reqId){
        requestService.deleteRequest(reqId);
        return ResponseEntity.ok("Deleted Request");
    }



    /**
     * @author - AkashKanaparthi
     * @return
     */
    @GetMapping("/requests")
    @RolesAllowed("manager")
    ResponseEntity<List<Request>> getAllRequests(){
        return ResponseEntity.ok(requestService.getAll());
    }
}
