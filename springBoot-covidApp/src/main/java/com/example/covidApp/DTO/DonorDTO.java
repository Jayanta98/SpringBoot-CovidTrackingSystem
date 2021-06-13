package com.example.covidApp.DTO;



public class DonorDTO {
	
	private int donorId;
	private String donorName;
	private String phoneNumber;
	private String bloodGroup;
	private String donorStatusMessage;
	
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getDonorStatusMessage() {
		return donorStatusMessage;
	}
	public void setDonorStatusMessage(String donorStatusMessage) {
		this.donorStatusMessage = donorStatusMessage;
	}
	
	

}
