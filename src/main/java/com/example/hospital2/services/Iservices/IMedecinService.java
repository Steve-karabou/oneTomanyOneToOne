package com.example.hospital2.services.Iservices;

import com.example.hospital2.models.Medecin;

import java.util.Collection;
import java.util.Optional;

public interface IMedecinService {
    public Medecin saveMedecin(Medecin medecin);
    public Collection<Medecin> getMedecins();
    public Optional<Medecin> getOneMedecin(Long id);
    public String deleteMedecin(Long id);
    public Medecin updateMedecin(Long id, Medecin medecin);
}
