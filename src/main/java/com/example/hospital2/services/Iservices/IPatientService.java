package com.example.hospital2.services.Iservices;

import com.example.hospital2.models.Patient;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface IPatientService {
 public Patient savePatient(Patient patient);
 public Page<Patient> getPatients(int page, int pageSize);
 public  Page<Patient> searchByName(int page, int pageSize, String key);
 public Optional<Patient> getOnePatient(Long id);
 public String deletePatient(Long id);
 public Patient updatePatient(Long id, Patient patient);


}
