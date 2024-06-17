package com.example.springboot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddressDto {
	
	private long id;
	@NotEmpty
	@Size(min = 2, message = "AddressName should have atleast 2 character")
	private String addressName;
	@NotEmpty
	@Size(min = 2, message = "PinCode should have atleast 2 character")
	private String pinCode;
}
