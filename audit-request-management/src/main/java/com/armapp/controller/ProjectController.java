package com.armapp.controller;

import com.armapp.model.Project;
import com.armapp.modelDTOs.ProjectVO;
import com.armapp.service.IProjectService;
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

    @GetMapping("/projects/{name}")
    @RolesAllowed("manager")
    ResponseEntity<List<ProjectVO>> showProjectVODetails(@PathVariable("name") String name){
        List<Project> projectList = iProjectService.getAllProjectVos(name);
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

    @GetMapping("/projects")
    @RolesAllowed("manager")
    ResponseEntity<List<ProjectVO>> getAllProjects(){
        List<Project> projectList = iProjectService.getAll();
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

