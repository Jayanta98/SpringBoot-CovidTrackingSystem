package com.example.covidApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donor_tbl")
public class Donor {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "doner_id")
private int donorId;

@Column(name = "doner_name")
private String donorName;

@Column(name = "doner_phonenumber")
private String phoneNumber;

@Column(name = "doner_bloodgroup")
private String bloodGroup;

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

@Override
public String toString() {
	return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", phoneNumber=" + phoneNumber + ", bloodGroup="
			+ bloodGroup + "]";
}





}