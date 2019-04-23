package com.fit.bmi.controllers;

import com.fit.bmi.models.User;
import com.fit.bmi.payload.DTOconverter;
import com.fit.bmi.payload.UserDTO;
import com.fit.bmi.repositories.UserRepository;
import com.fit.bmi.services.BmiCalculatorImpl;
import com.fit.bmi.services.CRUDUserServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private CRUDUserServices crudUserServices;
    private BmiCalculatorImpl bmiCalculator;
    private DTOconverter dtOconverter;


    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody UserDTO newUserDTO) {
        return crudUserServices.registerUser(dtOconverter.convertDTOtoUser(newUserDTO));
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return crudUserServices.getAll();
    }


    @PostMapping("/bmi/{userId}")
    public Double bmi(@PathVariable Long userId){
        return bmiCalculator.calculateBmi(userId);
    }



    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO updateUserDTO) {
        return crudUserServices.updateUser(dtOconverter.convertDTOtoUser(updateUserDTO), userId);
    }

    @DeleteMapping("/deleteuser/{userId}")
    void deleteEmployee(@PathVariable Long userId) {
        crudUserServices.deleteUser(userId);
    }

}
