package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Category;
import com.armapp.model.Request;
import com.armapp.model.RequestSchedule;
import com.armapp.model.Task;
import com.armapp.repository.CategoryRepository;
import com.armapp.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */

@Service
public class RequestServiceImpl implements IRequestService{

    private RequestRepository requestRepository;
    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    /**
     * to create a new request
     * @author - BabaSriHarsha
     * @param request
     * @return
     */
    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    /**
     * @author - BabaSriHarsha
     * to get all the requests available
     * @return
     */
    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    /**
     * to get details of a particular request
     * @author - Madhu Shree
     * @param id
     * @return
     */
    @Override
    public Request getById(Integer id) {
        return requestRepository.findById(id).get();
    }

    /**
     * to get request created by a particular user id
     * @param createdByUser
     * @return
     */
    @Override
    public List<Request> findByAssignedUserId(String createdByUser) {
        return requestRepository.findByAssignedUserId(createdByUser);
    }
}
