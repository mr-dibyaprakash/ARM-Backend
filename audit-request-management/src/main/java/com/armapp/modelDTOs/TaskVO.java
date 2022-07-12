package com.armapp.modelDTOs;

import com.armapp.model.Category;
import com.armapp.model.Priority;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskVO {

    private int requestId;
    private Category taskDescription;
    private ProductionVO productionCompanyName;
    private ProjectVO projectName;
    private TalentVO talentName;
    private Priority priority;
    private ReportVO auditPeriod;
    private RequestScheduleVO dates;


}
