package com.armapp.modelDTOs;

import com.armapp.model.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

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
public class RequestVO {


    private Integer requestId;
    private Priority priority;
    private Union union;
    private Status status;
    private LocalDate requestCreatedDate;
    private LocalDate contractDate;
    private Production productionCompanyName;
    private Project projectName;
    private Talent talentName;
    private RequestSchedule requestSchedule;
    private Set<Task> tasks;

}
