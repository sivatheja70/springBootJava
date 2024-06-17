package com.example.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_employee_profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "emp_profile_id")
	private long profileId;
	@Column(name= "gender")
	private String gender;
	@Column(name= "blood_group")
	private String bloodGroup;
	@Column(name= "father_name")
	private String fatherName;
	@Column(name= "mother_name")
	private String motherName;
	@Column(name= "relation_status")
	private String relationStatus;
	@Column(name="joining_date")
	private String joiningDate;
	

}
