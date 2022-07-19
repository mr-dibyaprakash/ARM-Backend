package com.armapp.controller;

import com.armapp.model.*;
import com.armapp.repository.CategoryRepository;
import com.armapp.service.IRequestService;
import com.armapp.vo.ProjectVO;
import com.armapp.vo.RequestVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
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


    /**
     * @param request
     * @return
     * @author - AkashKanaparthi
     */
    @PostMapping("/requests")
    @RolesAllowed("manager")
    ResponseEntity<String> createRequest(@RequestBody Request request) {

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


        Set<Task> taskSet = new HashSet<>();
        Category category;
        Category categoryById;
        for (Task task1 : tasksList) {
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
    ResponseEntity<String> updateRequest(@RequestBody Request request) {
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
    ResponseEntity<String> deleteReq(@PathVariable("id") int reqId) {
        requestService.deleteRequest(reqId);
        return ResponseEntity.ok("Deleted Request");
    }


    /**
     * @return
     * @author - AkashKanaparthi
     */
    @GetMapping("/requests")
    @RolesAllowed("manager")
    ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(requestService.getAll());

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

    /**
     * @author BabaSriHarshaErranki
     * @return
     */
    @GetMapping("/requests-vo")
    @RolesAllowed("manager")
    ResponseEntity<List<RequestVO>> getAllRequestVOs() {
        List<Request> requests = requestService.getAll();
        List<RequestVO> requestVOList = new ArrayList<RequestVO>();
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> myMappingFiles = new ArrayList<>();
        myMappingFiles.add("dozerBeanMapping.xml");
        mapper.setMappingFiles(myMappingFiles);
        for (Request request : requests) {
            RequestVO requestVO = mapper.map(request, RequestVO.class);
            requestVOList.add(requestVO);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders
                        .add("desc", "get request vo list"))
                .body(requestVOList);
    }


}

