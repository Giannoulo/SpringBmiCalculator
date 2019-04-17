package com.fit.bmi.repositories;

import com.fit.bmi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by George Giannoulopoulos
 * on 16/4/2019.
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
