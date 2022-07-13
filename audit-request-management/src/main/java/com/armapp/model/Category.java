package com.armapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
public class Category {
    @Id
    private Integer categoryId;
    private String reportType;
    @ManyToMany
    @JoinTable(name = "request_category",
            joinColumns = {@JoinColumn(name = "request_id")},
            inverseJoinColumns = {@JoinColumn(name ="category_id")}
    )
    private List<Request> request;
    @OneToOne
    @JoinColumn(name = "reporter_id")
    private Reporter reporter;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
}
