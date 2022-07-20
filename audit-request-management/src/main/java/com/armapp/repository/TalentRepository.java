package com.armapp.repository;

import com.armapp.model.Talent;
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
public interface TalentRepository extends JpaRepository<Talent, Integer> {

    public List<Talent> findByTalentNameLike(String keyword);

    @Query(value = "select tp.contract_number from talent_project tp inner join talent t on t.talent_id = tp.talent_id where t.talent_name = 'Willem Dafoe'",nativeQuery = true)
    public String findByTalentName(String talentName);
}
