package com.armapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
public class Task {

    @Id
    @Column(name="task_id")
    private Integer taskId;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    // Task list page task.category.owner.ownerUserId = logged user id
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
    private LocalDateTime closedAt;
}
