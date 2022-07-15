package com.armapp.service;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public class ReporterServiceImpl implements IReporterService{
//
//    private ReporterRepository reporterRepository;
//    @Autowired
//    public void setReporterRepo(ReporterRepository reporterRepository) {
//        this.reporterRepository = reporterRepository;
//    }
//
//    /**
//     *
//     * @author - AkashKanaparthi
//     * @param reporters
//     */
//    @Override
//    public void addReporter(Set<Reporter> reporters) {
//        reporterRepository.saveAll(reporters);
//    }
//
//    /**
//     *
//     * @author - AkashKanaparthi
//     * @param reporter
//     */
//    @Override
//    public void updateReporter(Reporter reporter) {
//        Reporter reporter1 = reporterRepository.findById(reporter.getReporterId()).get();
//        reporter1.setUpdatedAt(LocalDateTime.now());
//        reporterRepository.save(reporter1);
//    }
//
//    /**
//     *
//     * @author - AkashKanaparthi
//     * @param reporterId
//     * @throws InvalidIdException
//     */
//    @Override
//    public void deleteReporter(int reporterId) throws InvalidIdException {
//        Reporter reporter = reporterRepository.findById(reporterId).get();
//        reporter.setDeleted(true);
//        reporterRepository.save(reporter);
//    }
//
//    /**
//     *
//     * @author - AkashKanaparthi
//     * @param reporterId
//     * @return
//     * @throws InvalidIdException
//     */
//    @Override
//    public Reporter getById(int reporterId) throws InvalidIdException{
//        return reporterRepository.findById(reporterId).get();
//    }
//
//    /**
//     * @author - AkashKanaparthi
//     * @return
//     */
//    @Override
//    public List<Reporter> getAll() {
//        return reporterRepository.findAll()
//                .stream()
//                .filter(reporter -> !reporter.isDeleted())
//                .sorted(Comparator.comparing(Reporter::getReporterName))
//                .collect(Collectors.toList());
//    }
}
