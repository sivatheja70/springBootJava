package com.example.springboot.service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.EmployeeProfile;

public interface IEmployeeProfileService {
	public EmployeeProfile createEmployeeProfile(Long employeeId,EmployeeProfile employeeProfile);
	public EmployeeProfile updateEmployeeProfile(Long employeeProfileId,EmployeeProfile employeeProfile) throws ResourceNotFoundException;
}
