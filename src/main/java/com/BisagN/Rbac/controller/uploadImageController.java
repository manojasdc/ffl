package com.BisagN.Rbac.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.BisagN.FFL.models.TbAdminSetting;
import com.BisagN.FFL.repository.AddPhotoRepository;

@RestController
public class uploadImageController {

	@Autowired
	AddPhotoRepository repo;

	private static final String UPLOAD_DIR = "C:\\srv\\FFLFILEadminimages\\";
	
	
	 @GetMapping("/imagelink/{filename}")
	    public ResponseEntity<Resource> getImage(@PathVariable("filename") String filename) throws IOException {
		 
	        Path imagePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();
	        UrlResource resource = new UrlResource(imagePath.toUri());

	        if (!resource.exists()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	        String contentType = "image/*";  // Change based on the actual image type

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_TYPE, contentType)
	                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;")
	                .body(resource);
	    }
	 
	@PostMapping(value = "/admin/uploadImage")
	public ResponseEntity<Map<String, String>> uploadImageData(@RequestParam("image") MultipartFile image,
			@RequestParam("flag") String flag, @RequestParam("text") String text) {
		
		try {
			// Check if the upload directory exists, if not, create it
			Path uploadDirPath = new File(UPLOAD_DIR).toPath();
			if (Files.notExists(uploadDirPath)) {
				Files.createDirectories(uploadDirPath); // Create the directory if it doesn't exist
				
			}

			// Get the file name and prepare the file path
			String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename(); // Create a unique file
																								// name
			Path targetLocation = new File(uploadDirPath + "/" + fileName).toPath();

			// Save the file to the directory
			Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			// Save the file path and other details in the database
			TbAdminSetting tbadminsetting = new TbAdminSetting();
			tbadminsetting.setImageurl("imagelink/"+fileName); // Store the relative file path
			tbadminsetting.setFlag(flag);
			tbadminsetting.setText(text);

			// Save to repository
			repo.save(tbadminsetting);

			// Prepare response
			Map<String, String> response = new HashMap<>();
			response.put("message", "Image uploaded and saved successfully!");

			// Return response with HTTP status OK
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (IOException e) {
			// Log the exception
			System.err.println("Error occurred while uploading image: " + e.getMessage());

			// Return error response with HTTP status INTERNAL_SERVER_ERROR
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "Failed to upload image");

			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/admin/getImageData/{id}")
	public ResponseEntity<Map<String, String>> getImageData(@PathVariable("id") Integer id) {
		try {
			// Fetch image data from the database using the ID
			Optional<TbAdminSetting> TbAdminSettingOpt = repo.findById(id);

			if (TbAdminSettingOpt.isPresent()) {
				TbAdminSetting TbAdminSetting = TbAdminSettingOpt.get();

				// Prepare response with the image path
				Map<String, String> response = new HashMap<>();
				response.put("imagePath", TbAdminSetting.getImageurl()); // Image path from the database

				// Return response with HTTP status OK
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				// If no image found with the provided ID
				Map<String, String> errorResponse = new HashMap<>();
				errorResponse.put("message", "Image not found for the provided ID");
				return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			// Log the exception
			System.err.println("Error occurred while fetching image data: " + e.getMessage());

			// Return error response with HTTP status INTERNAL_SERVER_ERROR
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "Failed to retrieve image data");

			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/admin/getAllImages")
	public ResponseEntity<?> getAllImages() {
		try {
			// Fetch all image data from the database
			List<TbAdminSetting> allImages = repo.findAll();

			// Prepare the response with Base64 encoded images
			Map<String, Object> response = new HashMap<>();
			List<Map<String, Object>> imageList = new ArrayList<>();

			for (TbAdminSetting image : allImages) {
				// Get the absolute file path from the database
				String imagePath =image.getImageurl(); 
				

				// Prepare image data with Base64 encoded image
				Map<String, Object> imageData = new HashMap<>();
				imageData.put("id", image.getId());
				imageData.put("flag", image.getFlag());
				imageData.put("text", image.getText());
				imageData.put("imagePath", imagePath); 
				// Add to the image list
				imageList.add(imageData);
			}

			// Prepare the final response
			response.put("images", imageList);

			// Return response with HTTP status OK
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			// Log the exception
			System.err.println("Error occurred while fetching all image data: " + e.getMessage());

			// Return error response with HTTP status INTERNAL_SERVER_ERROR
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "Failed to retrieve image data");

			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/admin/deleteById/{id}")
	public ResponseEntity<?> deleteImageById(@PathVariable Integer id) {
		try {
			Map<String, Object> response = new HashMap<>();
			repo.deleteById(id);
			response.put("message", "Image deleted successfully");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Failed to delete image data");

			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

}
