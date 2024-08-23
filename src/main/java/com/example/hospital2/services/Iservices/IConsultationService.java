package com.example.hospital2.services.Iservices;

import com.example.hospital2.models.Consultation;
import com.example.hospital2.models.RendezVous;

import java.util.Collection;
import java.util.Optional;

public interface IConsultationService {
    public Consultation saveConsultation(Consultation consultation);
    public Collection<Consultation> getConsultations();
    public Optional<Consultation> getOneConsultation(Long id);
    public String deleteConsultation(Long id);
    public Consultation updateConsultation(Long id, Consultation consultation);
}
