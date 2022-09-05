package com.armapp.service;

import com.armapp.model.Talent;
import com.armapp.model.Task;
import com.armapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author - Sipoy Sikindar
 * @date - 20-07-2022
 * @project - audit-request-management
 */
@Service
public class TaskServiceImpl implements ITaskService {

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * to get all the tasks available
     * @return
     */
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll()
                .stream()
                .filter(project -> !project.isDeleted())
                .sorted(Comparator.comparing(Task::getTaskId))
                .collect(Collectors.toList());
    }

    /**
     * to get all tasks assigned to a particular report owner
     * @author - Awadhesh
     * @param userId
     * @return
     */
    @Override
    public List<Task> findAllTasksAssignedTo(String userId) {

        return taskRepository.findByAssignedUserId(userId);
    }

    /**
     * to get a particular task
     * Awadhesh
     * @param taskId
     * @return
     */
    @Override
    public Task getByTaskId(Integer taskId) {
        return taskRepository.findByTaskId(taskId);
    }

    /**
     * to get all taskes of a particular request
     * @author - Madhu Shree
     * @param reqId
     * @return
     */
    @Override
    public List<Task> getTasksByReqId(Integer reqId) {
        return taskRepository.findTasksByReqId(reqId);
    }
}
