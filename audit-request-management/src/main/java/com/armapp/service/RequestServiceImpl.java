package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Request;
import com.armapp.model.RequestSchedule;
import com.armapp.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
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
    public void setRequestRepo(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param request
     */
    @Override
    public void addRequest(Request request) {
        request.setCreatedAt(LocalDateTime.now());
        RequestSchedule requestSchedule = request.getRequestSchedule();
        requestSchedule.setCreatedAt(LocalDateTime.now());
        request.setRequestSchedule(requestSchedule);
        requestRepository.save(request);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param request
     */
    @Override
    public void updateRequest(Request request) {
        Request request1 = requestRepository.findById(request.getRequestId()).get();
        request1.setUpdatedAt(LocalDateTime.now());
        requestRepository.save(request1);
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
}
