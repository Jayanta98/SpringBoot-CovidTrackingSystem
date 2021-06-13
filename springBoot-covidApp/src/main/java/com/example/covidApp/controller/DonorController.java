package com.example.covidApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.MarkerManager.Log4jMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.covidApp.DTO.DonorDTO;
import com.example.covidApp.entity.Donor;
import com.example.covidApp.exception.DonorException;
import com.example.covidApp.service.DonorService;

@RestController
@CrossOrigin
public class DonorController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(DonorController.class);
	
	@Autowired
	private DonorService donorService;
	
	//create Donor
	@PostMapping("/add-donor")
	public String postDonor(@RequestBody DonorDTO donorDTO) {
		try {
			Donor d = new Donor();
			d.setDonorName(donorDTO.getDonorName());
			d.setPhoneNumber(donorDTO.getPhoneNumber());
			d.setBloodGroup(donorDTO.getBloodGroup());
			
			LOGGER.info(d.toString());
			
			Donor savedDonor=donorService.saveDonor(d);
			LOGGER.info(savedDonor.toString());
			return "SUCCESS";
			
		} catch (Exception e) {
			// TODO: handle exception
			return "FAILED";
		}
	}
	
	//Get Single Donor
	@GetMapping("/donor")
	public DonorDTO getSingleDonorByID(@RequestParam("dID") int id) {
		try {
			
			Donor d = donorService.fetchSingleDonorById(id);
			DonorDTO dDTO = new DonorDTO();
			dDTO.setDonorId(d.getDonorId());
			dDTO.setDonorName(d.getDonorName());
			dDTO.setBloodGroup(d.getBloodGroup());
			dDTO.setPhoneNumber(d.getPhoneNumber());
			dDTO.setDonorStatusMessage("SUCCESS");
			return dDTO;
		} catch (Exception e) {
			// TODO: handle exception
			DonorDTO dDTO = new DonorDTO();
			dDTO.setDonorStatusMessage("FAIL"+e);
			return dDTO;
		}
		
	}
	
	//Get List of Donor
	@GetMapping("/donor-list")
	public List<DonorDTO> getListDonor(){
		try {
			
			List<Donor> donorList = donorService.fetchAllDonor();
			
			List<DonorDTO> donorDTOList =new ArrayList<>(); 
			
			for(Donor d :donorList) {
				
				DonorDTO dDTO = new DonorDTO();
				dDTO.setDonorId(d.getDonorId());
				dDTO.setDonorName(d.getDonorName());
				dDTO.setBloodGroup(d.getBloodGroup());
				dDTO.setPhoneNumber(d.getPhoneNumber());
				dDTO.setDonorStatusMessage("SUCCESS");
				
				donorDTOList.add(dDTO);
				
			}
			return donorDTOList;
			
			} catch (Exception e) {
			// TODO: handle exception
				throw new DonorException("FAIL TO GET ALL DONOR");
		}
	}
	
	//UPDATE 
	@PutMapping("/update-donor")
	public String updateDonor(@RequestBody DonorDTO donorDTO) {
		try {
			
		 Donor d = new Donor();
		d.setDonorId(donorDTO.getDonorId());
		d.setDonorName(donorDTO.getDonorName());
		d.setPhoneNumber(donorDTO.getPhoneNumber());
		d.setBloodGroup(donorDTO.getBloodGroup());
		
		Donor updatedDonor = donorService.updateDonor(d);
		if(updatedDonor!=null) {
			return "DONOR_UPDATE_SUCCESS";
		}else {
			return "DONOR_UPDATE_FAIL";
		}
		 
		} catch (Exception e) {
			// TODO: handle exception
			return "DONOR_UPDATE_EXCEPTION";
		}
	}
	
	//DeleteById
	@DeleteMapping("/delete-donor")
	public String deleteDonorById(@RequestParam("donorId")int dID) {
		return donorService.deleteDonorById(dID);
	}

}
