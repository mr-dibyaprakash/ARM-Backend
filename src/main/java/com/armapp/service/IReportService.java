package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Report;

import java.util.List;
import java.util.Set;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public interface IReportService {

    void addReport(Set<Report> report);
    void updateReport(Report report);
    void deleteReport(int reportId) throws InvalidIdException;
    Report getById(int reportId) throws InvalidIdException;

    List<Report> getAll();

}
