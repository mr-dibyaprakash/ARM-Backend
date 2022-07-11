package com.armapp.modelDTOs;

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
public class ProjectVO {

    private Integer projectId;
    private String projectName;
    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;
    private String isDeleted;
}
