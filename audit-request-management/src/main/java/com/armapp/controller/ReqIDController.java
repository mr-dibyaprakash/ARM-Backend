package com.armapp.controller;

import com.armapp.model.ReqID;
import com.armapp.service.IReqIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ReqIDController {

    private IReqIDService IReqIDService;

    @Autowired
    public void setIReqIDService(com.armapp.service.IReqIDService IReqIDService) {
        this.IReqIDService = IReqIDService;
    }

    @GetMapping("/reqid")
    @RolesAllowed("manager")
    ResponseEntity<ReqID> getNextReqID() {
        ReqID reqID = new ReqID();
        reqID.setCreatedAt(LocalDateTime.now());
        ReqID newReqId = IReqIDService.createReqID(reqID);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders
                        .add("desc", "new req id"))
                .body(newReqId);
    }

}
