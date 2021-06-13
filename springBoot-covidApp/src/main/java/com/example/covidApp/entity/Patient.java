package com.example.covidApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_tbl")
public class Patient {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "patient_id")
private int patientId;

@Column(name = "patient_fullName")
private String fullName;

@Column(name = "patient_phoneNumber")
private String phoneNumber;

@Column(name = "patient_bloodGroup")
private String bloodGroup;

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

@Override
public String toString() {
	return "Patient [patientId=" + patientId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
			+ ", bloodGroup=" + bloodGroup + "]";
}



}
