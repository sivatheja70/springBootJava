package com.example.springboot.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
	
	private long id;
	@NotEmpty
	@Size(min = 2, message = "FirstName should have atleast 2 character")
	private String firstName;
	@NotEmpty
	@Size(min = 2, message = "LastName should have atleast 2 character")
	private String lastName;
	@NotNull
	@Email
	private String emailId;
	@NotNull
	@Range(min = 1)
	@Min(value=0, message = "msg1" )
	@Digits(fraction = 0, integer = 10, message ="msg2") 
	private Integer empSalary;
	@Valid
	private EmployeeProfileDto profile;
	@Builder.Default
	@Valid
	private  List<EmployeeAddressDto> addr = new ArrayList<EmployeeAddressDto>();//list


	public EmployeeDto(String firstName, String lastName, String mail, Integer salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = mail;
		this.empSalary = salary;
	}
}
