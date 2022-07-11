package com.armapp.modelDTOs;

import lombok.*;

import java.time.LocalDate;

/**
 * @author - Akash
 * @date - 05-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestScheduleVO {

    private Integer requestScheduleId;
    private LocalDate requestCreated;
    private LocalDate expectedClosure;
    private LocalDate auditStartDate;
    private LocalDate auditEndDate;
    private LocalDate reportSubmission;
    private LocalDate settlementDate;
    private LocalDate receiptDate;
    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;
    private String isDeleted;
}
