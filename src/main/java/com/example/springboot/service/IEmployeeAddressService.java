package com.example.springboot.service;

import java.util.List;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.EmployeeAddress;

public interface IEmployeeAddressService {
	public EmployeeAddress updateEmployeeAddress(EmployeeAddress employeeAddress) throws ResourceNotFoundException;
	public List<Object[]> employeeAddress();
}
