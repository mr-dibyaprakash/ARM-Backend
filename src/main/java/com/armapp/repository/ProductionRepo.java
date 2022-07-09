package com.armapp.repository;

import com.armapp.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dibya Prakash Ojha
 * @date : 07-Jul-22
 * @project : audit-request-management
 */
@Repository
public interface ProductionRepo extends JpaRepository<Production, Integer> {
}
