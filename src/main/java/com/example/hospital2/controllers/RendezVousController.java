package com.example.hospital2.controllers;

import com.example.hospital2.models.RendezVous;
import com.example.hospital2.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class RendezVousController {
    @Autowired
    private RendezVousService rendezVousService;
    @PostMapping("/rendezVous")
    public RendezVous createRendezVous(@RequestBody  RendezVous rendezVous){
        return rendezVousService.saveRendezVous(rendezVous);
    }
    @GetMapping("/rendezVous")
    public Collection<RendezVous> getRendezVous(){
        return rendezVousService.getRendezVous();
    }
    @GetMapping("/rendezVous/{id}")
    public Optional<RendezVous> getOneRendezVous(@PathVariable Long id){
        return rendezVousService.getOneRendezVous(id);
    }
    @DeleteMapping("/rendezVous/{id}")
    public String deleteRendezVous(@PathVariable Long id){
        return rendezVousService.deleteRendezVous(id);
    }
    @PutMapping("/rendezVous/{id}")
    public RendezVous updateRendezVous(@PathVariable Long id, @RequestBody RendezVous rendezVous){
        return rendezVousService.updateRendezVous(id, rendezVous);
    }

}
