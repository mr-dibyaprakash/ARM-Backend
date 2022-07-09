package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Report;
import com.armapp.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public class ReportServiceImpl implements IReportService{

    private ReportRepo reportRepo;
    @Autowired
    public void setReportRepo(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param reports
     */
    @Override
    public void addReport(Set<Report> reports) {
        reportRepo.saveAll(reports);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param report
     */
    @Override
    public void updateReport(Report report) {
        Report report1 = reportRepo.findById(report.getReportId()).get();
        report1.setUpdatedAt(LocalDateTime.now());
        reportRepo.save(report1);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param reportId
     * @throws InvalidIdException
     */
    @Override
    public void deleteReport(int reportId) throws InvalidIdException {
        Report report = reportRepo.findById(reportId).get();
        report.setDeleted(true);
        reportRepo.save(report);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param reportId
     * @return
     * @throws InvalidIdException
     */
    @Override
    public Report getById(int reportId) throws InvalidIdException {
        return reportRepo.findById(reportId).get();
    }

    /**
     * @author - AkashKanaparthi
     * @return
     */
    @Override
    public List<Report> getAll() {
        return reportRepo.findAll()
                .stream()
                .filter(report -> !report.isDeleted())
                .collect(Collectors.toList());
    }
}
