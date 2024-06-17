package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.EmployeeDocuments;
import com.example.springboot.repository.EmployeeDocumentsRepository;

@Service
public class EmployeeDocumentsService implements IEmployeeDocumentsService{
	@Autowired
	private EmployeeDocumentsRepository employeeDocuemntsRepo;
	
	public List<EmployeeDocuments> allEmployeeDocuments(){
		return employeeDocuemntsRepo.findAll();
	}

	@Override
	public EmployeeDocuments createEmployeeDocument(EmployeeDocuments document) {
		return employeeDocuemntsRepo.save(document);
	}

	@Override
	public EmployeeDocuments employeeDocuemnrsByEmpID(Integer empID) {
		
		return employeeDocuemntsRepo.findById(empID).get();
	}

	@Override
	public void employeeDocuments(Integer empID) {
		EmployeeDocuments doc =  employeeDocuemntsRepo.findById(empID).get();
		employeeDocuemntsRepo.delete(doc);
	}
}
