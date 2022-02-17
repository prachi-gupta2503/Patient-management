package com.patients.management;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.patients.management.model.Patient;
import com.patients.management.repository.PatientRepository;

@SpringBootApplication
public class PatientManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PatientManagementApplication.class, args);
		
	}

}
