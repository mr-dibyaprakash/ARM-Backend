package com.armapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Task {

    @Id
    @GeneratedValue
    @Column(name="task_id")
    private Integer taskId;
    private int requestId;

    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;
    private String isDeleted;
}
