package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.EmployeeProfile;
import com.example.springboot.repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileServiceImpl implements IEmployeeProfileService{
	
	@Autowired
	private EmployeeProfileRepository employeeProfileRepository;
	
	@Autowired
	private IEmployeeService employeeService;
	
	public EmployeeProfile createEmployeeProfile(Long employeeId,EmployeeProfile employeeProfile) {
		if(employeeProfile != null) {
			EmployeeProfile updatedProfile=  employeeProfileRepository.save(employeeProfile);
			
			employeeService.updateEmployeeProfileId(employeeId,updatedProfile.getProfileId());
			
			return updatedProfile;
		}else {
			return null;
		}
	}
	public EmployeeProfile updateEmployeeProfile(Long employeeProfileId,EmployeeProfile employeeProfile) throws ResourceNotFoundException {
		
		EmployeeProfile employeeProfileOld = employeeProfileRepository.findById(employeeProfileId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeProfileId));
		
		employeeProfileOld.setMotherName(employeeProfile.getMotherName());
		employeeProfileOld.setFatherName(employeeProfile.getFatherName());
		employeeProfileOld.setBloodGroup(employeeProfile.getBloodGroup());
		employeeProfileOld.setGender(employeeProfile.getGender());
		employeeProfileOld.setRelationStatus(employeeProfile.getRelationStatus());
		
		final EmployeeProfile updatedEmployeeProfile = employeeProfileRepository.save(employeeProfileOld);
		
		return updatedEmployeeProfile;
	}
}	
