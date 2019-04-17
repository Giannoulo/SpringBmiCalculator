package com.fit.bmi.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by George Giannoulopoulos
 * on 16/4/2019.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bmi_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;
    private String lastName;

    private Integer age;
    private Double weight;
    private Double height;
}


