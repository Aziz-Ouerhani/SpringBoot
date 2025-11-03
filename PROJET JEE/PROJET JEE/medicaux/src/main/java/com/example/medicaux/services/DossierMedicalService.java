package com.example.medicaux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicaux.entities.DossierMedical;
import com.example.medicaux.entities.User;
import com.example.medicaux.repositories.DossierMedicalRepository;
import com.example.medicaux.repositories.UserRepository;

import java.util.List;

@Service
public class DossierMedicalService {

    @Autowired private DossierMedicalRepository dossierRepo;
    @Autowired private UserRepository userRepo;

    // CREATE
    public DossierMedical createDossier(DossierMedical dossier) {
        User patient = userRepo.findById(dossier.getPatient().getId()).orElse(null);
        User medecin = userRepo.findById(dossier.getMedecin().getId()).orElse(null);
        if (patient == null || !"PATIENT".equals(patient.getRole())) return null;
        if (medecin == null || !"MEDECIN".equals(medecin.getRole())) return null;
        dossier.setPatient(patient);
        dossier.setMedecin(medecin);
        return dossierRepo.save(dossier);
    }

    // READ ALL
    public List<DossierMedical> getAllDossiers() { return dossierRepo.findAll(); }

    // READ BY ID
    public DossierMedical getDossierById(Long id) {
        return dossierRepo.findById(id).orElse(null);
    }

    // READ BY PATIENT
    public List<DossierMedical> getByPatientId(Long patientId) {
        return dossierRepo.findByPatientId(patientId);
    }

    // UPDATE
    public DossierMedical updateDossier(Long id, DossierMedical details) {
        DossierMedical dossier = getDossierById(id);
        if (dossier == null) return null;
        dossier.setDiagnostic(details.getDiagnostic());
        return dossierRepo.save(dossier);
    }

    // DELETE
    public void deleteDossier(Long id) { dossierRepo.deleteById(id); }
}