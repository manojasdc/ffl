package com.BisagN.Rbac.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BisagN.FFL.models.TbAdminSetting;
import com.BisagN.FFL.repository.AddPhotoRepository;

@RestController
public class addPhotoController {
	
	@Autowired
	AddPhotoRepository repo;
	
	@PostMapping(value = "/admin/submitPhoto")
    public ResponseEntity<Map<String, String>> getPhotoData(@RequestBody TbAdminSetting tbadminsetting) {
		
		
		
		
        try {
            // Log the received data for debugging
            System.out.println("Received data: " + tbadminsetting.toString());
            
            repo.save(tbadminsetting);
            // Prepare response as JSON
            Map<String, String> response = new HashMap<>();
            response.put("message", "Photo data received successfully!");

            // Return the response as JSON with HTTP status OK
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception for debugging
            System.err.println("Error occurred: " + e.getMessage());

            // Prepare error response as JSON
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to process the photo data");

            // Return error response with HTTP status INTERNAL_SERVER_ERROR
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
