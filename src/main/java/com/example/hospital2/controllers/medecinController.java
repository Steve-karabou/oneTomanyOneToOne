package com.example.hospital2.controllers;

import com.example.hospital2.models.Medecin;
import com.example.hospital2.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class medecinController {
    @Autowired
    private MedecinService medecinService;
    @PostMapping("/medecin")
    public Medecin createMedecin(@RequestBody Medecin medecin){
        return medecinService.saveMedecin(medecin);
    }
    @GetMapping("/medecin")
    public Collection<Medecin> getMedecins(){
        return medecinService.getMedecins();
    }
    @GetMapping("/medecin/{id}")
    public Optional<Medecin> getOneMedecin(@PathVariable Long id){
        return medecinService.getOneMedecin(id);
    }
    @DeleteMapping("/medecin/{id}")
    public String deleteMedecin(@PathVariable Long id){
        return medecinService.deleteMedecin(id);
    }
    @PutMapping("/medecin/{id}")
    public Medecin updateMedecin(@PathVariable Long id, @RequestBody Medecin medecin){
        return medecinService.updateMedecin(id, medecin);
    }
}
