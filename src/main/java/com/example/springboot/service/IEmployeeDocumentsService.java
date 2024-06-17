package com.example.springboot.service;

import java.util.List;


import com.example.springboot.model.EmployeeDocuments;

public interface IEmployeeDocumentsService {
	public List<EmployeeDocuments> allEmployeeDocuments();


	public EmployeeDocuments createEmployeeDocument(EmployeeDocuments document);

	
	public EmployeeDocuments employeeDocuemnrsByEmpID(Integer empID);


	public void employeeDocuments(Integer empID);
}
