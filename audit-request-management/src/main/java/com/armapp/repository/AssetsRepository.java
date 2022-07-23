package com.armapp.repository;

import com.armapp.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dibya Prakash Ojha
 * @date : 21-Jul-22
 * @project : audit-request-management
 */
public interface AssetsRepository extends JpaRepository<Assets,Integer> {
}
