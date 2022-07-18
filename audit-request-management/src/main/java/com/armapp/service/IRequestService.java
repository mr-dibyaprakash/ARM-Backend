package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Request;

import java.util.List;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public interface IRequestService {

    void addRequest(Request request);
    void updateRequest(Request request);
    void deleteRequest(int requestId) throws InvalidIdException;
    Request getById(int requestId) throws InvalidIdException;

    List<Request> getAll();


    Request save(Request request);

    List<Request> findByAssignedUserId(String createdByUser);

}
