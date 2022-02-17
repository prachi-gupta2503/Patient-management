package com.patients.management.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.patients.management.model.Patient;

public interface PatientService {

	public Patient getPatient(long id);
	public Patient createPatient(Patient patient );
	public Patient updatePatient(long id,Patient patient );
	
	public boolean deletePatient(long id);
	public List<Patient> findPatients(Specification<Patient> specs);
	
	
}
