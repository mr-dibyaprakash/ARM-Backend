package com.armapp.repository;

import com.armapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 07-Jul-22
 * @project : audit-request-management
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("from Project p inner join p.production pd where p.projectName like ?1")
    List<Project> findAllProjectVos(String name);

}
