package com.example.medicaux.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicaux.entities.DossierMedical;

import java.util.List;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
    List<DossierMedical> findByPatientId(Long patientId);
}