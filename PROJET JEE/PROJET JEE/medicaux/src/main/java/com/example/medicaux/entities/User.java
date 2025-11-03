package com.example.medicaux.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String telephone;
    private LocalDate dateNaissance;
    private String role; // "PATIENT" ou "MEDECIN"
    private String motDePasse;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<DossierMedical> dossiersMedicaux;

    // Constructeurs
    public User() {}
    public User(String nom, String prenom, String telephone, LocalDate dateNaissance, String role, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.motDePasse = motDePasse;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public List<DossierMedical> getDossiersMedicaux() { return dossiersMedicaux; }
    public void setDossiersMedicaux(List<DossierMedical> dossiersMedicaux) { this.dossiersMedicaux = dossiersMedicaux; }
}