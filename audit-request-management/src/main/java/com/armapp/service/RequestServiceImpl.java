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
     *
     * @author - AkashKanaparthi
     * @param request
     */
    @Override
    public void addRequest(Request request) {
        requestRepository.save(request);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param request
     */
    @Override
    public void updateRequest(Request request) {
        requestRepository.save(request);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param requestId
     * @throws InvalidIdException
     */
    @Override
    public void deleteRequest(int requestId) throws InvalidIdException{
        Request request = requestRepository.findById(requestId).get();
        request.setDeleted(true);
        requestRepository.save(request);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param requestId
     * @return
     * @throws InvalidIdException
     */
    @Override
    public Request getById(int requestId) throws InvalidIdException {
        return requestRepository.findById(requestId).get();
    }

    /**
     * @author - AkashKanaparthi
     * @return
     */
    @Override
    public List<Request> getAll() {
        return requestRepository.findAll()
                .stream()
                .filter(request -> !request.isDeleted())
                .sorted(Comparator.comparing(Request::getRequestId))
                .collect(Collectors.toList());
    }

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> findByAssignedUserId(String createdByUser) {
        return requestRepository.findByAssignedUserId(createdByUser);
    }
}
