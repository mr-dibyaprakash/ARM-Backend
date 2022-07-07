package com.armapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author - Akash
 * @date - 07-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Report {
    @Id
    private Integer reportId;
    private LocalDate audit_start_date;
    private LocalDate audit_end_date;

    @OneToOne(mappedBy = "report")
    private Request request;

    @OneToMany(mappedBy = "report")
    private Set<Category> category;

    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
    private boolean isDeleted;
}