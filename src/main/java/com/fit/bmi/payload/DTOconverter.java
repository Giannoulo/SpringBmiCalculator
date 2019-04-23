package com.fit.bmi.payload;

import com.fit.bmi.models.User;
import org.springframework.stereotype.Component;

@Component
public class DTOconverter {

    public User convertDTOtoUser(UserDTO userDTO){
        User convertedUser = new User();
        convertedUser.setHeight(userDTO.getHeight());
        convertedUser.setName(userDTO.getName());
        convertedUser.setAge(userDTO.getAge());
        convertedUser.setWeight(userDTO.getWeight());
        convertedUser.setLastname(userDTO.getLastname());

        return convertedUser;
    }
}
