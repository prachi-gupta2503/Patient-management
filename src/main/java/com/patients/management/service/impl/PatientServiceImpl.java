package com.patients.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.patients.management.model.Patient;
import com.patients.management.repository.PatientRepository;
import com.patients.management.service.PatientService;

@Service
public class PatientServiceImpl  implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public Patient getPatient(long id) {
		Patient patient=null;
		try {
			Optional<Patient> patientById = patientRepository.findById(id);
			if(!patientById.isEmpty())
				patient=patientById.get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return patient;
}

	@Override
	public Patient createPatient(Patient patient) {
		
		return patientRepository.save(patient);
		
	}

	@Override
	public Patient updatePatient(long id,Patient patient) {
		Patient p=null;
		try {
			Optional<Patient> patientById = patientRepository.findById(id);
			
			if(!patientById.isEmpty()) {
				p=patientById.get();
			    p.setName(patient.getName());
			    p.setAddress(patient.getAddress());
			    p.setDob(patient.getDob());
			    patientRepository.save(p);
		}
			    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}

	

	@Override
	public boolean deletePatient(long id) {
		Patient patient=null;
		  Optional<Patient> findById = patientRepository.findById(id);
		
		if(!findById.isEmpty()) {
			patient=findById.get();
			patientRepository.delete(patient);
			return true;
		}
		return false;
	}

	@Override
	public List<Patient> findPatients(Specification<Patient> specs) {
		 return patientRepository.findAll(Specification.where(specs));
			
	}
}
