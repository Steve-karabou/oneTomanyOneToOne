package com.example.hospital2.services;

import com.example.hospital2.models.Medecin;
import com.example.hospital2.repositories.MedecinRepository;
import com.example.hospital2.services.Iservices.IMedecinService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MedecinService implements IMedecinService {
    private MedecinRepository medecinRepository;

    public MedecinService(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    public Medecin saveMedecin(Medecin medecin){
       return medecinRepository.save(medecin);
    }
    public Collection<Medecin> getMedecins(){
        return medecinRepository.findAll();
    }
    public Optional<Medecin> getOneMedecin(Long id){
        return medecinRepository.findById(id);
    }
    public String deleteMedecin(Long id){
        medecinRepository.deleteById(id);
        return "Medecin delete";
    }
    public Medecin updateMedecin(Long id, Medecin medecin){
        return medecinRepository.findById(id).map(p->{
            p.setNom(medecin.getNom());
            p.setEmail(medecin.getEmail());
            p.setSpecialite(medecin.getSpecialite());
            return medecinRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Medecin note find"));
    }

}
