package com.example.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.EmployeeAddress;
import com.example.springboot.service.IEmployeeAddressService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeAddressController {
	
	@Autowired
	private IEmployeeAddressService employeeAddressService;
	
	/*@PostMapping("/employeeAddress/{id}")
	public EmployeeAddress createEmployeeAddress (@Valid @RequestBody EmployeeAddress employee,@PathVariable("id") Long id) {
		if(employee != null) {
			EmployeeAddress pro=  employeeAddrRepository.save(employee);
			employeeRepository.updateEmpProfileId(id,pro.getId());
			
			return pro;
		}else {
			return null;
		}
	}
	*/
	@PutMapping("/employee/address")
	public ResponseEntity<EmployeeAddress> updateEmployeeAddress(@Valid @RequestBody EmployeeAddress employeeAddress)
							throws ResourceNotFoundException {
		EmployeeAddress updatedEmployeeAddress = employeeAddressService.updateEmployeeAddress(employeeAddress);
		
		return ResponseEntity.ok(updatedEmployeeAddress);
	}
	@GetMapping("/employee/address")
	public List<Object[]> employeeAddress(){
		return employeeAddressService.employeeAddress();
	}
}
