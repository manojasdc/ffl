package com.BisagN.FFL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BisagN.models.Logininformation;

public interface LoginInformationRepository extends JpaRepository<Logininformation, Integer>{
	Logininformation findByUsername(String username);
}

