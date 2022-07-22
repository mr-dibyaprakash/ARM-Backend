package com.armapp.controller;

import com.armapp.model.Project;
import com.armapp.service.IProjectService;
import com.armapp.vo.ProjectVO;
import org.dozer.DozerBeanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProjectController {

    IProjectService iProjectService;

    public ProjectController(IProjectService iProjectService) {
        this.iProjectService = iProjectService;
    }

    @GetMapping("/projectNames/productionId/{productionId}/typedProjectName/{typedProjectName}")
//    @RolesAllowed("manager")
    ResponseEntity<List<ProjectVO>> showTypedProjectNames(@PathVariable("productionId") Integer productionId,@PathVariable("typedProjectName") String typedProjectName){
        List<Project> projectList = iProjectService.getTypedProjectNames(productionId,typedProjectName);
        List<ProjectVO> projectVOList = new ArrayList<ProjectVO>();
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> myMappingFiles = new ArrayList<>();
        myMappingFiles.add("dozerBeanMapping.xml");
        mapper.setMappingFiles(myMappingFiles);
        for (Project project : projectList) {
            ProjectVO projectVO = mapper.map(project, ProjectVO.class);
            projectVOList.add(projectVO);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders
                        .add("desc", "get project names like"))
                .body(projectVOList);
    }



    @GetMapping("/projectNames/productionId/{productionId}")
//    @RolesAllowed("manager")
    ResponseEntity<List<ProjectVO>> getAllProjectNames(@PathVariable("productionId") Integer productionId){
        List<Project> projectList = iProjectService.getAllProjectNames(productionId);
        List<ProjectVO> projectVOList = new ArrayList<ProjectVO>();
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> myMappingFiles = new ArrayList<>();
        myMappingFiles.add("dozerBeanMapping.xml");
        mapper.setMappingFiles(myMappingFiles);
        for (Project project : projectList) {
            ProjectVO projectVO = mapper.map(project, ProjectVO.class);
            projectVOList.add(projectVO);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders
                        .add("desc", "get all project"))
                .body(projectVOList);
    }



}

