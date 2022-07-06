package com.armapp.repository;

import com.armapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepo extends JpaRepository<User, Integer> {
}
