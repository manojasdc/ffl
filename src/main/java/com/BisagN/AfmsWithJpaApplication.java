package com.BisagN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BisagN.controller.AESGCM;
import com.BisagN.util.Base64Service;

@SpringBootApplication
public class AfmsWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfmsWithJpaApplication.class, args);
		
	}

}
