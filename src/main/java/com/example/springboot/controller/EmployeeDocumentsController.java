package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.EmployeeDocuments;
import com.example.springboot.service.IEmployeeDocumentsService;

@RestController
@RequestMapping("/api/documents")
public class EmployeeDocumentsController {
	@Autowired
	private IEmployeeDocumentsService employeeDocumentService;
	
	@GetMapping("/all")
	public List<EmployeeDocuments> allEmployeeDocuments() {
		return employeeDocumentService.allEmployeeDocuments();
	}
	@PostMapping("/employeeDocument")
	public EmployeeDocuments createEmployeeDocument(@RequestBody EmployeeDocuments document) {
		return employeeDocumentService.createEmployeeDocument(document);
	}
	@GetMapping("/{id}")
	public EmployeeDocuments employeeDocumentsByEmpId(@PathVariable(value = "id")Integer empID) {
		return employeeDocumentService.employeeDocuemnrsByEmpID(empID);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> employeeDocuments(@PathVariable(value = "id")Integer empID) {
		employeeDocumentService.employeeDocuments(empID);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.ACCEPTED);
	}
}
