package com.fit.bmi.services;


import com.fit.bmi.models.User;
import com.fit.bmi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BmiCalculatorImpl {

    private  UserRepository userRepository;


    @Autowired
    public BmiCalculatorImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public double calculateBmi(Long id) {

        Optional<User> user = userRepository.findById(id);



        User presentUser = user.get();

        Integer age = presentUser.getAge();
        Double weight = presentUser.getWeight();
        Double height = presentUser.getHeight();

        double bmi = weight/Math.pow(height,2);

        return bmi;
    }
}
