package com.example.hospital2.services;

import com.example.hospital2.models.Patient;
import com.example.hospital2.repositories.PatientRepository;
import com.example.hospital2.services.Iservices.IPatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {

private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient){
      return patientRepository.save(patient);
     }

 public Page<Patient> getPatients(int page, int pageSize){
     Pageable pageable = PageRequest.of(page, pageSize);
        return patientRepository.findAll(pageable);
 }

 public  Page<Patient> searchByName(int page, int pageSize, String key){
        System.out.println("KARA:"+key);
        return patientRepository.chercher(key, PageRequest.of(page, pageSize));
 }

 public Optional<Patient> getOnePatient(Long id){
        return patientRepository.findById(id);
 }

 public String deletePatient(Long id){
        patientRepository.deleteById(id);
   return "Patient Delete";
 }

 public Patient updatePatient(Long id, Patient patient){

        return patientRepository.findById(id).map(p->{
            p.setDateNaissance(patient.getDateNaissance());
            p.setNom(patient.getNom());
            p.setMalade(patient.isMalade());
            return patientRepository.save(p);
        }).orElseThrow(()-> new RuntimeException("Patient not find"));

 }
}
