package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Project;
import com.armapp.modelDTOs.ProjectVO;
import com.armapp.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
@Service
public class ProjectServiceImpl implements IProjectService{

    private ProjectRepo projectRepo;
    @Autowired
    public void setProjectRepo(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param projects
     */
    @Override
    public void addProject(Set<Project> projects) {
        projectRepo.saveAll(projects);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param project
     */
    @Override
    public void updateProject(Project project) {
        Project project1 = projectRepo.findById(project.getProjectId()).get();
        project1.setUpdatedAt(LocalDateTime.now());
        projectRepo.save(project1);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param projectId
     * @throws InvalidIdException
     */
    @Override
    public void deleteProject(int projectId) throws InvalidIdException {
        Project project = projectRepo.findById(projectId).get();
        project.setDeleted(true);
        projectRepo.save(project);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param projectId
     * @return project object
     * @throws InvalidIdException
     */
    @Override
    public Project getById(int projectId) throws InvalidIdException{
        return  projectRepo.findById(projectId).get();
    }

    /**
     * @author - AkashKanaparthi
     * @return
     */
    @Override
    public List<Project> getAll() {
        return projectRepo
                .findAll()
                .stream()
                .filter(project -> !project.isDeleted())
                .sorted(Comparator.comparing(Project::getProjectName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> getAllProjectVos(String name) {
        return projectRepo.findAllProjectVos(name + "%");


    }

}
