package com.armapp.repository;

import com.armapp.model.Production;
import com.armapp.modelDTOs.ProductionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dibya Prakash Ojha
 * @date : 07-Jul-22
 * @project : audit-request-management
 */
@Repository
public interface ProductionRepo extends JpaRepository<Production, Integer> {

    // get the list of production companyNames according to the input parameters
    List<Production> findByProductionCompanyNameLike(String companyName);
}
