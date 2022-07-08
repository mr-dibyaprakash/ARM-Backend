package com.armapp.repository;

import com.armapp.model.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dibya Prakash Ojha
 * @date : 07-Jul-22
 * @project : audit-request-management
 */
public interface ReporterRepo extends JpaRepository<Reporter, Integer> {
}
