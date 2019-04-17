package com.fit.bmi.payload;

import lombok.Data;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @Size(min = 2, max = 200, message = "Name must be between 2 and 200 characters.")
    private String name;

    @Size(min = 2, max = 200, message = "Last name must be between 2 and 200 characters.")
    private String lastName;

    @Positive(message = "Age must be positive.")
    private Integer age;
    @Positive(message = "Weight must be positive.")
    private Double weight;
    @Positive(message = "Height must be positive.")
    private Double height;
}
