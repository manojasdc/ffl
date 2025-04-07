package com.BisagN.FFL.controllers;

import java.util.*;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.BisagN.FFL.models.TbBulletin;
import com.BisagN.FFL.models.TbBulletinApproval;
import com.BisagN.FFL.models.TbBulletinComments;
import com.BisagN.FFL.repository.BulletinRepository;

import com.BisagN.FFL.repository.BulletinApprovalRepository;
import com.BisagN.FFL.repository.BulletinCommentsRepository;

@RestController
public class BulletinController {

	@Autowired
	private BulletinRepository repo;

	@Autowired
	private BulletinCommentsRepository commentsRepo;

	@Autowired
	private BulletinApprovalRepository approvalRepo;

	@Autowired
	JdbcTemplate template;

	@GetMapping("/admin/bulletin")
	public ModelAndView getBulletinModel() {
		return new ModelAndView("bulletin");
	}

	@GetMapping("/admin/bulletinApproval")
	public ModelAndView getBulletinApprovalModel() {
		return new ModelAndView("bulletin_approval");
	}

	// Fetch all bulletins
	@GetMapping("/admin/getAllBulletin")
	public ResponseEntity<?> getAllBulletins(Principal principal) {
		try {
//			List<TbBulletin> bulletins = repo.findAll();
//			String loggedInUser = principal.getName();
			List<Object[]> data = repo.getAllBulletins(principal.getName());
			
			
			List<Map<String, Object>> formattedData = data.stream().map(obj -> {
			    Map<String, Object> bulletinMap = new HashMap<>();
			    bulletinMap.put("bulletin_id", obj[0]);
			    bulletinMap.put("title", obj[1]);
			    bulletinMap.put("description", obj[2]);
			    bulletinMap.put("created_by", obj[3]);
			    bulletinMap.put("date", obj[4]);
			    
			    // Check if principal.getName() matches created_by
			    String createdBy = (String) obj[3]; 
			    String approvalStatus = (String) obj[5];
			    
			    if (principal.getName().equals(createdBy)) {
			        approvalStatus = "T"; // Set approval_status to 'T'
			    }
			    
			    bulletinMap.put("approval_status", approvalStatus);
			    
			    return bulletinMap;
			}).collect(Collectors.toList());

//			 
//			List<TbBulletin> finaldata = bulletins.stream().map(bull -> {
//				Optional<String> bulletinStatus = Optional.ofNullable(template.queryForObject(
//						"SELECT EXISTS (SELECT 1 FROM tb_bulletin_approval WHERE bulletin_id = ? and username= ?  LIMIT 1)",
//						String.class, new Object[] { bull.getId(), loggedInUser }));
//				bull.setAprovalstatus(bulletinStatus.orElse(""));
//
//				// Determine whether the logged-in user is the creator
//				if (loggedInUser.equals(bull.getCreated_by())) {
//					bull.setCreated_by(""); // Hide created_by for the creator
//				}
//
//				return bull;
//			}).collect(Collectors.toList());

			if (formattedData.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
			}

			return ResponseEntity.ok().contentType(org.springframework.http.MediaType.APPLICATION_JSON).body(formattedData);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/admin/getAllApprovalBulletins")
	public ResponseEntity<?> getRequestedbulletin(Principal principal) {
		try {
			List<Object[]> requestedbulletins = approvalRepo.getAllRequestedBulletins(principal.getName());

			// Ensure that an empty JSON array is returned instead of 'undefined'
			if (requestedbulletins.isEmpty()) {
				return ResponseEntity.ok(Collections.emptyList()); // Returns []
			}

			List<Map<String, Object>> jsonList = new ArrayList<>();

			for (Object[] row : requestedbulletins) {
				Map<String, Object> map = new HashMap<>();
				map.put("bulletin_id", row[0]);
				map.put("username", row[1]);
				map.put("title", row[2]);
				map.put("approveStatus", row[3]);
				jsonList.add(map);
			}

			return ResponseEntity.ok().contentType(org.springframework.http.MediaType.APPLICATION_JSON).body(jsonList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/admin/getComments/{bulletinId}")
	public ResponseEntity<List<TbBulletinComments>> getComments(@PathVariable("bulletinId") int bulletinId) {
		try {
			List<TbBulletinComments> comments = commentsRepo.findByBulletinId(bulletinId);

			if (!comments.isEmpty()) {
				return ResponseEntity.ok(comments);
			}

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/admin/submitBulletin")
	public ResponseEntity<String> submitBulletin(@RequestBody TbBulletin bulletin, Principal principal) {
		try {
			bulletin.setDate(LocalDate.now());
			bulletin.setCreated_by(principal.getName());
			// Save the bulletin to DB
			repo.save(bulletin);
			return ResponseEntity.ok("Bulletin submitted successfully!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed to submit bulletin: " + e.getMessage());
		}
	}

	@PostMapping("/admin/submitComment")
	public ResponseEntity<String> submitComment(@RequestBody TbBulletinComments bulletinComment) {
		try {
			System.out.println(bulletinComment.toString());

			commentsRepo.save(bulletinComment);
			return new ResponseEntity<>("submitted", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/admin/requestApproval/{bulletinId}")
	public ResponseEntity<?> requestApproval(@PathVariable("bulletinId") int id, Principal principal) {
		try {

			if (principal == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
			}

			// Save bulletin approval details
			TbBulletinApproval approval = new TbBulletinApproval();
			approval.setUsername(principal.getName()); // Set user ID
			approval.setBulletin_id(id); // Set bulletin ID
			approval.setApproveStatus("PENDING");

			approvalRepo.save(approval);

			return ResponseEntity.ok("Approval request saved successfully" + approval);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving approval request");
		}
	}

	@PostMapping("/admin/updateApprovalStatus")
	public ResponseEntity<?> updateApproveStatus(@RequestBody Map<String, Object> requestBody) {
	    try {
	        int bulletinId = (int) requestBody.get("bulletin_id");
	        String username = (String) requestBody.get("username");
	        String updateStatus = (String) requestBody.get("status");

	        System.out.println(bulletinId + " " + username + " " + updateStatus);

	        if ("REJECTED".equalsIgnoreCase(updateStatus)) {
	            // If rejected, delete the entry from TbBulletinApproval table
	            approvalRepo.deleteByBulletinIdAndUsername(bulletinId, username);
	            return ResponseEntity.ok("Approval entry deleted due to rejection.");
	        } else {
	            // Update approval status if not rejected
	            int updatedRows = approvalRepo.updateApprovalStatus(bulletinId, username, updateStatus);

	            if (updatedRows > 0) {
	                return ResponseEntity.ok("Approval request saved successfully.");
	            } else {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Approval request could not be processed.");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving approval request");
	    }
	}


}
