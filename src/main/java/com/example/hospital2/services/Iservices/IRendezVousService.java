package com.example.hospital2.services.Iservices;

import com.example.hospital2.models.RendezVous;

import java.util.Collection;
import java.util.Optional;

public interface IRendezVousService {
    public RendezVous saveRendezVous(RendezVous rendezVous);
    public Collection<RendezVous> getRendezVous();
    public Optional<RendezVous> getOneRendezVous(Long id);
    public String deleteRendezVous(Long id);
    public RendezVous updateRendezVous(Long id, RendezVous rendezVous);
}
