package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Request;
import com.armapp.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public class RequestServiceImpl implements IRequestService{

    private RequestRepo requestRepo;
    @Autowired
    public void setRequestRepo(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param request
     */
    @Override
    public void addRequest(Set<Request> request) {
        requestRepo.saveAll(request);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param request
     */
    @Override
    public void updateRequest(Request request) {
        Request request1 = requestRepo.findById(request.getRequestId()).get();
        request1.setUpdatedAt(LocalDateTime.now());
        requestRepo.save(request1);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param requestId
     * @throws InvalidIdException
     */
    @Override
    public void deleteRequest(int requestId) throws InvalidIdException{
        Request request = requestRepo.findById(requestId).get();
        request.setDeleted(true);
        requestRepo.save(request);
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
        return requestRepo.findById(requestId).get();

    }

    /**
     * @author - AkashKanaparthi
     * @return
     */
    @Override
    public List<Request> getAll() {
        return requestRepo.findAll()
                .stream()
                .filter(request -> !request.isDeleted())
                .sorted(Comparator.comparing(Request::getRequestId))
                .collect(Collectors.toList());
    }
}
