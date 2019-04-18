package com.fit.bmi.controllers;

import com.fit.bmi.models.User;
import com.fit.bmi.payload.DTOconverter;
import com.fit.bmi.payload.UserDTO;
import com.fit.bmi.repositories.UserRepository;
import com.fit.bmi.services.BmiCalculatorImpl;
import com.fit.bmi.services.CRUDUserServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@Api(value = "This is the User controller")
@RequestMapping("/api")
public class UserController {

    private CRUDUserServices crudUserServices;
    private BmiCalculatorImpl bmiCalculator;
    private DTOconverter dtOconverter;

    @ApiOperation("This endpoint will create a user")
    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody UserDTO newUserDTO) {
        return crudUserServices.registerUser(dtOconverter.convertDTOtoUser(newUserDTO));
    }

    @ApiOperation(value = "This endpoint will return a list of all Users")
    @GetMapping("/users")
    public List<User> listOfUsers (){
        return crudUserServices.getUsers();
    }

    @ApiOperation(value = "This endpoint will update a User")
    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO updateUserDTO) {
        return crudUserServices.updateUser(dtOconverter.convertDTOtoUser(updateUserDTO), userId);
    }

    @ApiOperation(value = "This endpoint will delete a User")
    @DeleteMapping("/user/{userId}")
    void deleteEmployee(@PathVariable Long userId) {
        crudUserServices.deleteUser(userId);
    }

}
