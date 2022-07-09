package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Reporter;

import java.util.List;
import java.util.Set;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public interface IReporterService {

    void addReporter(Set<Reporter> reporter);
    void updateReporter(Reporter reporter);
    void deleteReporter(int reporterId) throws InvalidIdException;
    Reporter getById(int reporterId) throws InvalidIdException;

    List<Reporter> getAll();

}
