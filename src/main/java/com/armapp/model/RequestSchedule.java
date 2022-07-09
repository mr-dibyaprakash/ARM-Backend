package com.armapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author - Akash Kanaparthi
 * @date - 05-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestSchedule {
    @Id
    private Integer requestScheduleId;
    private LocalDate requestCreated;
    private LocalDate expectedClosure;
    private LocalDate auditStartDate;
    private LocalDate auditEndDate;
    private LocalDate reportSubmission;
    private LocalDate settlementDate;
    private LocalDate receiptDate;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
}
