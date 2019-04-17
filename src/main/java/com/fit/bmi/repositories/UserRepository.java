package com.fit.bmi.repositories;

import com.fit.bmi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by George Giannoulopoulos
 * on 16/4/2019.
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
