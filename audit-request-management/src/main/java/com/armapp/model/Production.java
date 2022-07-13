package com.armapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

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
public class Production {

    @Id
    @Column(name = "production_id")
    private Integer productionId;
    private String productionCompanyName;

    @OneToMany(mappedBy = "production")
    private Set<Project> projects;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
}
