package com.armapp.repository;

import com.armapp.model.Talent;
import com.armapp.modelDTOs.TalentVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 07-Jul-22
 * @project : audit-request-management
 */
@Repository
public interface TalentRepo extends JpaRepository<Talent, Integer> {

    public List<Talent> findByTalentNameLike(String keyword);
}
