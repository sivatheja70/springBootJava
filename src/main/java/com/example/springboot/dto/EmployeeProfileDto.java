package com.example.springboot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfileDto {

	private long profileId;
	@NotEmpty
	@Size(min = 2, message = "Gender should have atleast 2 character")
	private String gender;
	@NotEmpty
	@Size(min = 2, message = "BloodGroup should have atleast 2 character")
	private String bloodGroup;
	@NotEmpty
	@Size(min = 2, message = "FatherName should have atleast 2 character")
	private String fatherName;
	@NotEmpty
	@Size(min = 2, message = "MotherName should have atleast 2 character")
	private String motherName;
	@NotEmpty
	@Size(min = 2, message = "RelationStatus should have atleast 2 character")
	private String relationStatus;
	@NotEmpty
	@Size(min = 2, message = "JoiningDate should have atleast 2 character")
	private String joiningDate;
}
