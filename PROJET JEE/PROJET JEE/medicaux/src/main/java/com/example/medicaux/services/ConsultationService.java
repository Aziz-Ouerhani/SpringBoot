package com.example.medicaux.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicaux.entities.Consultation;
import com.example.medicaux.entities.DossierMedical;
import com.example.medicaux.repositories.ConsultationRepository;
import com.example.medicaux.repositories.DossierMedicalRepository;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired private ConsultationRepository consultRepo;
    @Autowired private DossierMedicalRepository dossierRepo;

    // CREATE
    public Consultation addConsultation(Long dossierId, Consultation consultation) {
        DossierMedical dossier = dossierRepo.findById(dossierId).orElse(null);
        if (dossier == null) return null;
        consultation.setDossierMedical(dossier);
        return consultRepo.save(consultation);
    }

    // READ ALL BY DOSSIER
    public List<Consultation> getByDossierId(Long dossierId) {
        return consultRepo.findByDossierMedicalId(dossierId);
    }

    // READ BY ID
    public Consultation getById(Long id) {
        return consultRepo.findById(id).orElse(null);
    }

    // UPDATE
    public Consultation updateConsultation(Long id, Consultation details) {
        Consultation c = getById(id);
        if (c == null) return null;
        c.setNotes(details.getNotes());
        c.setDate(details.getDate());
        return consultRepo.save(c);
    }

    // DELETE
    public void deleteConsultation(Long id) { consultRepo.deleteById(id); }
}