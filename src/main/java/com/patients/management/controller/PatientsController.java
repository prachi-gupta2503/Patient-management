package com.patients.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patients.management.model.Patient;
import com.patients.management.repository.PatientRepository;
import com.patients.management.service.PatientService;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping("/patient")
public class PatientsController {

	@Autowired
	PatientService patientService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable("id")long id) {
		Patient patient = patientService.getPatient(id);
		
		if(patient==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(patient));
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Patient> createpatient(@RequestBody Patient patient) {
		Patient p=null;
		try {
		p= patientService.createPatient(patient);
		return ResponseEntity.of(Optional.of(p));
		
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatepatient(@PathVariable("id")long id,@RequestBody Patient patient) {
	    Patient p=null;
		
	    p=patientService.updatePatient(id,patient);
	    if(p==null)
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   return new ResponseEntity<Patient>(patientService.getPatient(id), HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Patient> Deletepatient(@PathVariable("id")long id) {
		 boolean satus = patientService.deletePatient(id);
		 if(satus) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
		     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Patient>>searchPatient(@SearchSpec Specification<Patient> value) {
		//?search=(id:1 And name:"poonam  kumari")
		List<Patient> patients=patientService.findPatients(value);
		if(patients.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(patients));
		
	}
	
	
	
}
