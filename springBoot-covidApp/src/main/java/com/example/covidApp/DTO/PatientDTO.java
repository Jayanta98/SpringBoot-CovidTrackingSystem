package com.example.covidApp.DTO;



public class PatientDTO {

	
	private int patientId;
	private String fullName;
	private String phoneNumber;
	private String bloodGroup;
	private String patientStatusMessage;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getPatientStatusMessage() {
		return patientStatusMessage;
	}
	public void setPatientStatusMessage(String patientStatusMessage) {
		this.patientStatusMessage = patientStatusMessage;
	}
	
	

}
