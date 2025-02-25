package com.sample.spring_security.Repository;

import com.sample.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String username);
}
