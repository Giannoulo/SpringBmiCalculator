package com.fit.bmi.services;


import com.fit.bmi.models.User;
import com.fit.bmi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BmiCalculatorImpl {

    private  UserRepository userRepository;


    @Autowired
    public BmiCalculatorImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public double calculateBmi() {
//        return 0; //TODO
//    }
//
//    public List<User> getUsers(){
//        return userRepository.findAll();
//    }
}
