package com.example.covidApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.covidApp.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer> {

}
