package com.example.hospital2.services;

import com.example.hospital2.models.Consultation;
import com.example.hospital2.models.RendezVous;
import com.example.hospital2.repositories.ConsultationRepository;
import com.example.hospital2.services.Iservices.IConsultationService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ConsultationService implements IConsultationService {
    private ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Consultation saveConsultation(Consultation consultation){
        return consultationRepository.save(consultation);
    }
    public Collection<Consultation> getConsultations(){
        return consultationRepository.findAll();
    }
    public Optional<Consultation> getOneConsultation(Long id){
        return consultationRepository.findById(id);
    }
    public String deleteConsultation(Long id){
        consultationRepository.deleteById(id);
        return "Consultation is Delete";
    }
    public Consultation updateConsultation(Long id, Consultation consultation){
        return consultationRepository.findById(id).map(p->{
            p.setDateConsultation(consultation.getDateConsultation());
            p.setRapport(consultation.getRapport());
            p.setRendezVous(consultation.getRendezVous());
            return consultationRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Consultation not find"));

    }
}
