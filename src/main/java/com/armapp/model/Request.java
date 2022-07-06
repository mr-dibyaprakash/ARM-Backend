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
public class Request {

    @Id
    @GeneratedValue
    private Integer requestId;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Union union;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate requestCreatedDate;
    private LocalDate contractDate;

    @OneToOne
    @JoinColumn(name = "production_id")
    private Production productionCompanyName;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project projectName;

    @OneToOne
    @JoinColumn(name = "talent_id")
    private Talent talentName;

    @OneToOne
    @JoinColumn(name = "request_schedule_id")
    private RequestSchedule requestSchedule;

    @OneToMany
    @JoinColumn(name="task_id")
    @ToString.Exclude
    private Set<Task> tasks;

    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
    private boolean isDeleted;

}
