/**
 * @Author:Awadhesh
 * @Date:05-07-2022
 * @Time:23:15
 * @Project Name:Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
package com.armapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private Integer id;
    private String name;
}
