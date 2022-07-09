package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Reporter;
import com.armapp.repository.ReporterRepo;
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
public class ReporterServiceImpl implements IReporterService{

    private ReporterRepo reporterRepo;
    @Autowired
    public void setReporterRepo(ReporterRepo reporterRepo) {
        this.reporterRepo = reporterRepo;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param reporters
     */
    @Override
    public void addReporter(Set<Reporter> reporters) {
        reporterRepo.saveAll(reporters);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param reporter
     */
    @Override
    public void updateReporter(Reporter reporter) {
        Reporter reporter1 = reporterRepo.findById(reporter.getReporterId()).get();
        reporter1.setUpdatedAt(LocalDateTime.now());
        reporterRepo.save(reporter1);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param reporterId
     * @throws InvalidIdException
     */
    @Override
    public void deleteReporter(int reporterId) throws InvalidIdException {
        Reporter reporter = reporterRepo.findById(reporterId).get();
        reporter.setDeleted(true);
        reporterRepo.save(reporter);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param reporterId
     * @return
     * @throws InvalidIdException
     */
    @Override
    public Reporter getById(int reporterId) throws InvalidIdException{
        return reporterRepo.findById(reporterId).get();
    }

    /**
     * @author - AkashKanaparthi
     * @return
     */
    @Override
    public List<Reporter> getAll() {
        return reporterRepo.findAll()
                .stream()
                .filter(reporter -> !reporter.isDeleted())
                .sorted(Comparator.comparing(Reporter::getReporterName))
                .collect(Collectors.toList());
    }
}
