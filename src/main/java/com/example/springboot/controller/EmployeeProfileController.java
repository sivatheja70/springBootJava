package com.example.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.EmployeeProfile;
import com.example.springboot.service.IEmployeeProfileService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeProfileController {
	@Autowired
	private  IEmployeeProfileService employeeProfileService;
	
	@PostMapping("/employee/profile/{id}")
	public EmployeeProfile createEmployeeProfile(@PathVariable(value = "id") Long employeeId,@Valid @RequestBody EmployeeProfile employeeProfile) {
		return employeeProfileService.createEmployeeProfile(employeeId, employeeProfile);
	}
	@PutMapping("/employee/profile/{id}")
	public ResponseEntity<EmployeeProfile> updateEmployeeProfile(@RequestParam("profileId") Long employeeProfileId,
			@Valid @RequestBody EmployeeProfile employeeProfile) throws ResourceNotFoundException {
		EmployeeProfile updatedEmployeeProfile = employeeProfileService.updateEmployeeProfile(employeeProfileId, employeeProfile);
		return ResponseEntity.ok(updatedEmployeeProfile);
	}
}
