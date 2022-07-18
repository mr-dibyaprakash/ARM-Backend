package com.armapp.vo;

import com.armapp.model.Priority;
import com.armapp.model.Status;
import com.armapp.model.Union;
import lombok.*;

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
    private ProductionVO productionCompanyName;
    private ProjectVO projectName;
    private TalentVO talentName;
    private RequestScheduleVO requestSchedule;
//    private Set<Task> tasks;

}
