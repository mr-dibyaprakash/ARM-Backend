package com.armapp.controller;

import com.armapp.model.Request;
import com.armapp.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author - Akash Kanaparthi
 * @date - 12-07-2022
 * @project - AUDIT-REQUEST-MANAGEMENT_BE
 */
@RestController
@RequestMapping("request-api")
public class RequestController {

    private IRequestService requestService;
    @Autowired
    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param request
     * @return
     */
    @PostMapping("/requests")
    ResponseEntity<String> createRequest(@RequestBody Request request){
        requestService.addRequest(request);
        return ResponseEntity.status(HttpStatus.OK).body("Created Request");
    }

    /**
     * @author - AkashKanaparthi
     * @return
     */
    @GetMapping("/requests")
    ResponseEntity<List<Request>> getAllRequests(){
        return ResponseEntity.ok(requestService.getAll());
    }
}
