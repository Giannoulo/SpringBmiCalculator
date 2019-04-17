package com.fit.bmi.controllers;

import com.fit.bmi.models.User;
import com.fit.bmi.repositories.UserRepository;
import com.fit.bmi.services.BmiCalculatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {



    private UserRepository userRepository;
    private BmiCalculatorImpl bmiCalculator;


    @Autowired
    public UserController(UserRepository userRepository, BmiCalculatorImpl bmiCalculator) {
        this.userRepository = userRepository;
        this.bmiCalculator = bmiCalculator;
    }

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user){
        return userRepository.save(user);

    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return bmiCalculator.getUsers();
    }
}
