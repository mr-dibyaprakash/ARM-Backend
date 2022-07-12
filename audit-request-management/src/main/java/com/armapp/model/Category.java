package com.armapp.model;

import lombok.*;

import javax.persistence.*;
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
public class Category {
    @Id
    private Integer categoryId;
    private String reportType;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
    @OneToOne
    @JoinColumn(name = "reporter_id")
    private Reporter reporter;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
}
