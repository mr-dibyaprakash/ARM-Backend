package com.armapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author - Akash
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

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @OneToMany(mappedBy = "production")
    private Set<Project> projects;

    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
    private boolean isDeleted;
}
