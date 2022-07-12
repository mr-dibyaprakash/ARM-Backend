package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Request;

import java.util.List;
import java.util.Set;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public interface IRequestService {

    void addRequest(Set<Request> request);
    void updateRequest(Request request);
    void deleteRequest(int requestId) throws InvalidIdException;
    Request getById(int requestId) throws InvalidIdException;

    List<Request> getAll();

}
