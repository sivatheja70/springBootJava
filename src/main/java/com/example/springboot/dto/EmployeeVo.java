package com.example.springboot.dto;


import lombok.Data;

@Data
public class EmployeeVo {
	
	private Long empId;
	private String empName;
	
	public EmployeeVo(Long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	
}	
