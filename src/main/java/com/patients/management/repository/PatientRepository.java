package com.patients.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.patients.management.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> , JpaSpecificationExecutor<Patient> {

	//public findByName
}
