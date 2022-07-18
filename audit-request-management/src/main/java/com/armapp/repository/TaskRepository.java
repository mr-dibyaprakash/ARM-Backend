package com.armapp.repository;

import com.armapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value="SELECT t FROM Task t WHERE t.category.owner.ownerId = :ownerId")
    List<Task> findByAssignedUserId(Integer ownerId);
}
