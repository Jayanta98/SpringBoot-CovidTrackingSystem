package com.example.covidApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covidApp.entity.Patient;
import com.example.covidApp.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	//Create
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	//FetchSingle
	public Patient fetchSinglePatientById(int id) {
		return patientRepo.findById(id).orElse(null);
	}
	//FetchAllPatient
	public List<Patient> fetchAllPatient(){
		return patientRepo.findAll();
	}
	//Update
	public Patient updatePatient(Patient patient) {
		Patient exitPatient = patientRepo.findById(patient.getPatientId()).orElse(null);
	
			exitPatient.setFullName(patient.getFullName());
			exitPatient.setPhoneNumber(patient.getPhoneNumber());
			exitPatient.setBloodGroup(patient.getBloodGroup());
			return patientRepo.save(exitPatient);
			
		
	}
	//Delete By Id
	public String deletePatientById(int id) {
		Patient exitPatient = patientRepo.findById(id).orElse(null);
		System.out.println(exitPatient.getFullName());
	
			patientRepo.deleteById(id);
			return "SUCCESS";
		
		
	}

}
