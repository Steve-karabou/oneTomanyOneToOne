package com.example.hospital2.repositories;

import com.example.hospital2.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
    Page<Patient> findByNomContains(String keyword, Pageable pageable);
    @Query("select p from Patient p where p.nom like %:x%")
    Page<Patient> chercher(@Param("x") String keyword, Pageable pageable);
}
