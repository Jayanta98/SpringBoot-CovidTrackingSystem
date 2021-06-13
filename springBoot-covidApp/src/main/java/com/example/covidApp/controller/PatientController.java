package com.example.covidApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.covidApp.DTO.PatientDTO;
import com.example.covidApp.DTO.Status;
import com.example.covidApp.entity.Patient;
import com.example.covidApp.exception.PatientException;
import com.example.covidApp.service.PatientService;

@RestController
@CrossOrigin
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/add-patient")
	public Status postPatient(@RequestBody PatientDTO patientDto) {
		try {
			
			Patient p = new Patient();
			p.setFullName(patientDto.getFullName());
			p.setPhoneNumber(patientDto.getPhoneNumber());
			p.setBloodGroup(patientDto.getBloodGroup());
			Patient savedPatient= patientService.savePatient(p);
			Status s = new Status();
			s.setMessage("SUCCESS");
			return s;
			
		} catch (PatientException e) {
			Status s = new Status();
			s.setMessage("FAIL");
			return s;
			
		}
	}
	
	@GetMapping("/patient")
	public PatientDTO getSinglePatientById(@RequestParam("patientId") int pId) {
		try {
			Patient p = patientService.fetchSinglePatientById(pId);
			PatientDTO pDTO = new PatientDTO();
			pDTO.setPatientId(p.getPatientId());
			pDTO.setFullName(p.getFullName());
			pDTO.setPhoneNumber(p.getPhoneNumber());
			pDTO.setBloodGroup(p.getBloodGroup());
			pDTO.setPatientStatusMessage("SUCCESS");
			System.out.println(pDTO.toString());
			return pDTO;
		} catch (Exception e) {
			// TODO: handle exception
			PatientDTO pDTO = new PatientDTO();
		
			pDTO.setPatientStatusMessage("FAIL");
			return pDTO;
		}
	}
	
	@GetMapping("/patient-list")
	public List<PatientDTO> getPatientList(){
		try {
			List<Patient> pList = patientService.fetchAllPatient();
			List<PatientDTO> patientDTOList = new ArrayList<>();
			for(Patient p :pList) {
				PatientDTO pDTO = new PatientDTO();
				pDTO.setPatientId(p.getPatientId());
				pDTO.setFullName(p.getFullName());
				pDTO.setPhoneNumber(p.getPhoneNumber());
				pDTO.setBloodGroup(p.getBloodGroup());
				pDTO.setPatientStatusMessage("SUCCESS");
				patientDTOList.add(pDTO);
			}
			return patientDTOList;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new PatientException("ERROR FOR GETTING ALL PATIENT");
		}
		
	}
	
	@PutMapping("/update-patient")
	public Status updatePatient(@RequestBody PatientDTO pDTO) {
		try {
			Patient patient = new Patient();
			patient.setPatientId(pDTO.getPatientId());
			patient.setFullName(pDTO.getFullName());
			patient.setPhoneNumber(pDTO.getPhoneNumber());
			patient.setBloodGroup(pDTO.getBloodGroup());
			Patient updatedPatient = patientService.updatePatient(patient);
			if(updatedPatient!=null) {
				Status s = new Status();
				s.setMessage("SUCCESS");
				return s;
			}else {
				Status s = new Status();
				s.setMessage("FAILED");
				return s;
			}
		} catch (Exception e) {
			// TODO: handle exception
			Status s = new Status();
			s.setMessage("Exception");
			return s;
		}
	}
	//Return object from backend always;
	@DeleteMapping("/delete-patient")
	public Status deletePatientById(@RequestParam("patientId") int pID) {
		Status s = new Status();
		s.setMessage(patientService.deletePatientById(pID));
		return s;
		
	}
	
}
