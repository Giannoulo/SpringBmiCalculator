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
@Table(name="bmi_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;
    private String lastname;

    private Integer age;
    private Double weight;
    private Double height;
}


