package com.armapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author - Akash Kanaparthi
 * @date - 12-07-2022
 * @project - audit-request-management
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestID {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "")

    private long id;
}
