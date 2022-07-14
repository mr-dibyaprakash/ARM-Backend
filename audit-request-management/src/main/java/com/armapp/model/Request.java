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
public class Request {

    @Id
    private Integer requestId;
    //    @Enumerated(EnumType.STRING)
    private String priority;
    //    @Enumerated(EnumType.STRING)
    private String union;
    //    @Enumerated(EnumType.STRING)
    private String status;
    private LocalDate requestCreatedDate;
    private LocalDate contractDate;
    private LocalDate auditStartDate;
    private LocalDate auditEndDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "production_id")
    private Production production;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_schedule_id")
    private RequestSchedule requestSchedule;

    @ManyToMany(mappedBy = "request",cascade = CascadeType.ALL)
    private Set<Category> category;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private boolean isDeleted;

}
