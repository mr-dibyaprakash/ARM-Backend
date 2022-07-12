package com.armapp.repository;

import com.armapp.model.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dibya Prakash Ojha
 * @date : 07-Jul-22
 * @project : audit-request-management
 */
@Repository
public interface TalentRepo extends JpaRepository<Talent, Integer> {
}
