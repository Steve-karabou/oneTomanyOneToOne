package com.example.hospital2.controllers;

import com.example.hospital2.models.Consultation;
import com.example.hospital2.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @PostMapping("/consultation")
    public Consultation createConsultation(@RequestBody Consultation consultation){
        return consultationService.saveConsultation(consultation);
    }
    @GetMapping("/consultation")
    public Collection<Consultation> getConsultations(){
        return consultationService.getConsultations();
    }
    @GetMapping("/consultation/{id}")
    public Optional<Consultation> getOneConsultation(@PathVariable Long id){
        return consultationService.getOneConsultation(id);
    }
    @DeleteMapping("/consultation/{id}")
    public String DeleteConsultation(@PathVariable Long id){
        return consultationService.deleteConsultation(id);
    }
    @PutMapping("/consultation/{id}")
    public Consultation updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation){
        return consultationService.updateConsultation(id, consultation);
    }


}
