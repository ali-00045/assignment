package com.task.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.task.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUsername(String username);

}
