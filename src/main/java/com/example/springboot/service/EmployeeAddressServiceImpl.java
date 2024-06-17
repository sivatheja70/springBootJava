package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.EmployeeAddress;
import com.example.springboot.repository.EmployeeAddressRepository;

@Service
public class EmployeeAddressServiceImpl implements IEmployeeAddressService{
	@Autowired
	private EmployeeAddressRepository employeeAddressRepository;
	
	@Override
	public EmployeeAddress updateEmployeeAddress(EmployeeAddress employeeAddress) throws ResourceNotFoundException {
		
		EmployeeAddress employee = employeeAddressRepository.findById(employeeAddress.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee Address not found for this id :: " + employeeAddress.getId()));

		employee.setAddressName(employeeAddress.getAddressName());
		employee.setPinCode(employeeAddress.getPinCode());
		
		final EmployeeAddress updatedEmployee = employeeAddressRepository.save(employee);
		
		return updatedEmployee;
	}
	public List<Object[]> employeeAddress(){	
		
		return employeeAddressRepository.employeeAddress();
	}

}
