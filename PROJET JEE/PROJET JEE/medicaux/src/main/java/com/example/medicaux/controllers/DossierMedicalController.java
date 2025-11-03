package com.example.medicaux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.medicaux.entities.DossierMedical;
import com.example.medicaux.services.DossierMedicalService;

import java.util.List;

@RestController
@RequestMapping("/api/dossiers")
public class DossierMedicalController {

    @Autowired private DossierMedicalService service;

    @GetMapping
    public List<DossierMedical> getAll() { return service.getAllDossiers(); }

    @PostMapping
    public DossierMedical create(@RequestBody DossierMedical dossier) {
        return service.createDossier(dossier);
    }

    @GetMapping("/{id}")
    public DossierMedical getById(@PathVariable Long id) {
        return service.getDossierById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<DossierMedical> getByPatient(@PathVariable Long patientId) {
        return service.getByPatientId(patientId);
    }

    @PutMapping("/{id}")
    public DossierMedical update(@PathVariable Long id, @RequestBody DossierMedical dossier) {
        return service.updateDossier(id, dossier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteDossier(id);
        return ResponseEntity.noContent().build();
    }
}