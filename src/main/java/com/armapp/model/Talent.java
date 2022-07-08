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
public class Talent {

    @Id
    @Column(name = "talent_id")
    private Integer talentId;
    private String talentName;

    @ManyToMany(mappedBy = "talents")
    private Set<Project> projects;

    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
    private boolean isDeleted;

}
