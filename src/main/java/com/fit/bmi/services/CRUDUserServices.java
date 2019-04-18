package com.fit.bmi.services;

import com.fit.bmi.models.User;
import com.fit.bmi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CRUDUserServices {
    private UserRepository userRepository;

    @Autowired
    public CRUDUserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(User userToBeUpdated, Long userId) {
        return userRepository.findById(userId).
                map(user -> {
                    user.setName(userToBeUpdated.getName());
                    user.setLastName(userToBeUpdated.getLastName());
                    user.setAge(userToBeUpdated.getAge());
                    user.setWeight(userToBeUpdated.getWeight());
                    user.setHeight(userToBeUpdated.getHeight());
                    return userRepository.save(user);
                })
                .orElseThrow (()-> new EntityNotFoundException());
                }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public User registerUser(User user){
        return userRepository.save(user);

    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
