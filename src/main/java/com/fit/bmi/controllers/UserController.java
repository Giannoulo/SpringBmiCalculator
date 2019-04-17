package com.fit.bmi.controllers;

import com.fit.bmi.models.User;
import com.fit.bmi.payload.DTOconverter;
import com.fit.bmi.payload.UserDTO;
import com.fit.bmi.services.BmiCalculatorImpl;
import com.fit.bmi.services.CRUDUserServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private CRUDUserServices crudUserServices;
    private BmiCalculatorImpl bmiCalculator;
    private DTOconverter dtOconverter;

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody UserDTO newUserDTO) {
        return crudUserServices.registerUser(dtOconverter.convertDTOtoUser(newUserDTO));
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return bmiCalculator.getUsers();
    }

    //Update user by id
    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO updateUserDTO) {
        return crudUserServices.updateUser(dtOconverter.convertDTOtoUser(updateUserDTO), userId);
    }

    @DeleteMapping("/user/{userId}")
    void deleteEmployee(@PathVariable Long userId) {
        crudUserServices.deleteUser(userId);
    }

}
