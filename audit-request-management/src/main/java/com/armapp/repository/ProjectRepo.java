package com.armapp.repository;

import com.armapp.model.Project;
import com.armapp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dibya Prakash Ojha
 * @date : 07-Jul-22
 * @project : audit-request-management
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
