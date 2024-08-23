package com.example.hospital2.services;

import com.example.hospital2.models.RendezVous;
import com.example.hospital2.repositories.RendezVousRepository;
import com.example.hospital2.services.Iservices.IRendezVousService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RendezVousService implements IRendezVousService {

    private RendezVousRepository rendezVousRepository;

    public RendezVousService(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public RendezVous saveRendezVous(RendezVous rendezVous){
        return rendezVousRepository.save(rendezVous);
    }
    public Collection<RendezVous> getRendezVous(){
        return rendezVousRepository.findAll();
    }
    public Optional<RendezVous> getOneRendezVous(Long id){
       return rendezVousRepository.findById(id);
    }
    public String deleteRendezVous(Long id){
        rendezVousRepository.deleteById(id);
        return "RendezVous is Delete";
    }
    public RendezVous updateRendezVous(Long id, RendezVous rendezVous){
        return rendezVousRepository.findById(id).map(p->{
            p.setDate(rendezVous.getDate());
            p.setStatus(rendezVous.getStatus());
            p.setPatient(rendezVous.getPatient());
            p.setMedecin(rendezVous.getMedecin());
           return rendezVousRepository.save(p);
        }).orElseThrow(()->new RuntimeException("RendezVous not find"));
    }
}
