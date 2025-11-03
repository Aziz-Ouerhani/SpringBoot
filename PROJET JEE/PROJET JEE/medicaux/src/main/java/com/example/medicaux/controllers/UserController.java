package com.example.medicaux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.medicaux.entities.User;
import com.example.medicaux.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping
    public List<User> getAll() { return userService.getAllUsers(); }

    @GetMapping("/patients")
    public List<User> getPatients() { return userService.getPatients(); }

    @GetMapping("/medecins")
    public List<User> getMedecins() { return userService.getMedecins(); }

    @PostMapping
    public User create(@RequestBody User user) { return userService.createUser(user); }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) { return userService.getUserById(id); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}