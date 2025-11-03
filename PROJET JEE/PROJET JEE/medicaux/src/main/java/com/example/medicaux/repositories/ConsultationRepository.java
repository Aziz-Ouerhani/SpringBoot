package com.example.medicaux.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicaux.entities.Consultation;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByDossierMedicalId(Long dossierId);
}