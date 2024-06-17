package com.example.springboot.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.dto.EmployeeVo;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Employee;
import org.json.JSONException;

public interface IEmployeeService {
	public Map<String,List<Employee>> getAllEmployeeByMonthandYear() throws ParseException;
	public List<Employee> getEmployeesByjoiningDate(String startDate,String endDate,String minSal,String maxSal) throws ParseException, JSONException;
	
	public List<EmployeeDto> allEmployees();
	public EmployeeDto employeeById(Long employeeId) throws ResourceNotFoundException ;
	public EmployeeDto createEmployee(EmployeeDto employeeDto) throws ResourceNotFoundException;
	public void deleteEmployee(Long employeeId) throws ResourceNotFoundException;
	public void updateEmployeeProfileId(Long employeeId,Long employeeProfileId);
	
	
	public List<Employee> employeesbyJoiningDate(String startDate,String endDate,String minSal,String maxSal);
	public List<EmployeeVo> employeeByEmpName(String empName);
	public List<EmployeeVo> employeeBySalary(String empSal);
}
