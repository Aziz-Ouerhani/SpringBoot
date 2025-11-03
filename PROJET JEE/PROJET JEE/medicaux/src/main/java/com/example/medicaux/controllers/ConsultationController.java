package com.example.medicaux.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.medicaux.entities.Consultation;
import com.example.medicaux.services.ConsultationService;

import java.util.List;

@RestController
@RequestMapping("/api/dossiers/{dossierId}/consultations")
public class ConsultationController {

    @Autowired private ConsultationService service;

    @GetMapping
    public List<Consultation> getAll(@PathVariable Long dossierId) {
        return service.getByDossierId(dossierId);
    }

    @PostMapping
    public Consultation create(@PathVariable Long dossierId, @RequestBody Consultation consultation) {
        return service.addConsultation(dossierId, consultation);
    }

    @GetMapping("/{id}")
    public Consultation getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Consultation update(@PathVariable Long id, @RequestBody Consultation consultation) {
        return service.updateConsultation(id, consultation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteConsultation(id);
        return ResponseEntity.noContent().build();
    }
}