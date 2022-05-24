package com.training.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByFirstName(String firstName);

	List<User> findByRole(boolean role);
}

