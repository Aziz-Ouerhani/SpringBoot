package com.example.medicaux.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicaux.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);
}