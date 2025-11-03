package com.example.medicaux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicaux.entities.User;
import com.example.medicaux.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired private UserRepository userRepo;

    // CREATE
    public User createUser(User user) {
        if (!"PATIENT".equals(user.getRole()) && !"MEDECIN".equals(user.getRole())) {
            throw new IllegalArgumentException("Rôle doit être PATIENT ou MEDECIN");
        }
        return userRepo.save(user);
    }

    // READ ALL
    public List<User> getAllUsers() { return userRepo.findAll(); }

    // READ BY ID
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // READ PATIENTS
    public List<User> getPatients() { return userRepo.findByRole("PATIENT"); }

    // READ MEDECINS
    public List<User> getMedecins() { return userRepo.findByRole("MEDECIN"); }

    // UPDATE
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user == null) return null;
        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setTelephone(userDetails.getTelephone());
        user.setDateNaissance(userDetails.getDateNaissance());
        user.setRole(userDetails.getRole());
        user.setMotDePasse(userDetails.getMotDePasse());
        return userRepo.save(user);
    }

    // DELETE
    public void deleteUser(Long id) { userRepo.deleteById(id); }
}