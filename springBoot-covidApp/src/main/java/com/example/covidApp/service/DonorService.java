package com.example.covidApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covidApp.entity.Donor;
import com.example.covidApp.repository.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository donorRepo;
	
	//Create Donor
	public Donor saveDonor(Donor donor) {
		return donorRepo.save(donor);
	}
	//Fetch single Donor
	public Donor fetchSingleDonorById(int id) {
		return donorRepo.findById(id).orElse(null);
	}
	
	//FetchAll Donor
	public List<Donor> fetchAllDonor(){
		return donorRepo.findAll();
		}
	
	//Update
	public Donor updateDonor(Donor donor) {
		Donor existingDonor= donorRepo.findById(donor.getDonorId()).orElse(null);
		if(existingDonor!=null) {
			existingDonor.setDonorName(donor.getDonorName());
			existingDonor.setPhoneNumber(donor.getPhoneNumber());
			existingDonor.setBloodGroup(donor.getBloodGroup());
			return donorRepo.save(existingDonor);
		}else {
			return null;
		}
		
	}
	
	//Delete Donor
	public String deleteDonorById(int id) {
		Donor existingDonor= donorRepo.findById(id).orElse(null);
		if(existingDonor!=null) {
			donorRepo.deleteById(id);
			return "SUCCESS";
		}else {
			return "FAILED";
		}
	}

}
