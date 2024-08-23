package com.example.hospital2.controllers;

import com.example.hospital2.models.Patient;
import com.example.hospital2.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class PatientController {
@Autowired
private PatientService patientService;
 @PostMapping("/patient")
 public Patient createPatient(@RequestBody @Valid Patient patient) {
     System.out.println(patient);
     return patientService.savePatient(patient);
 }

 @GetMapping("/patient")
 public Page<Patient> getPatients(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int pageSize){
     return patientService.getPatients(page, pageSize);
 }

    @GetMapping("/patient/search")
    public Page<Patient> searchByName(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int pageSize,
                                      @RequestParam(defaultValue = "") String kw){
        return patientService.searchByName(page, pageSize, kw);
    }

@GetMapping("/patient/{id}")
 public Optional<Patient> getOnePatient(@PathVariable  Long id) {
     return patientService.getOnePatient(id);
 }
 @DeleteMapping("/patient/{id}")
 public String PatientDelete(@PathVariable Long id){
     return patientService.deletePatient(id);
 }
 @PutMapping("/patient/{id}")
 public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient){
     return patientService.updatePatient(id, patient);
 }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
