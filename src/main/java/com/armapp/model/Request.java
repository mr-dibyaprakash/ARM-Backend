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
    private Integer requestId;
//    @Enumerated(EnumType.STRING)
    private String priority;
//    @Enumerated(EnumType.STRING)
    private String union;
//    @Enumerated(EnumType.STRING)
    private String status;
    private LocalDate requestCreatedDate;
    private LocalDate contractDate;

    @OneToOne
    @JoinColumn(name = "report_id")
    private Report report;

    @OneToOne(mappedBy = "request")
    private Production productionCompanyName;

    @OneToOne
    @JoinColumn(name = "request_schedule_id")
    private RequestSchedule requestSchedule;

    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
    private boolean isDeleted;

}
