package com.example.springboot.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.dto.EmployeeVo;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Employee;
import com.example.springboot.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	

	@GetMapping("/employees")
	public List<EmployeeDto> allEmployees() {
		return employeeService.allEmployees();
	}
	
	@PostMapping("/employee")
	public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employee) throws ResourceNotFoundException {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> employeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		EmployeeDto employee = employeeService.employeeById(employeeId);
		return ResponseEntity.ok().body(employee);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody EmployeeDto employeeDetails) throws ResourceNotFoundException {
		final EmployeeDto updatedEmployee = employeeService.createEmployee(employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		
		employeeService.deleteEmployee(employeeId);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	@GetMapping("/employees/monthyear")
	public @ResponseBody Map<String,List<Employee>> allEmployeesByMonthYear() throws ParseException{
		Map<String,List<Employee>> map = employeeService.getAllEmployeeByMonthandYear();
		return map;
	}
	@GetMapping("/employee")
	public List<Employee> getEmployeesByjoiningDate(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,
					@RequestParam("minSal") String minSal,@RequestParam("maxSal") String maxSal)throws ParseException{
			
		//return employeeService.getEmployeesByjoiningDate(startDate,endDate,minSal,maxSal);
		return employeeService.employeesbyJoiningDate(startDate, endDate, minSal, maxSal);
	}
	@GetMapping("/getByProcEmpList")
	public List<EmployeeVo> employeeByEmpName(@RequestParam("empName") String empName){
		return employeeService.employeeByEmpName(empName);
	}
	@GetMapping("/getEmployeeListBySal")
	public List<EmployeeVo> employeeBySalary(@RequestParam("empSal") String empSal){
		return employeeService.employeeBySalary(empSal);
	}
}
