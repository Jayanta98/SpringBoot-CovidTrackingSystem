package com.example.covidApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.covidApp.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
