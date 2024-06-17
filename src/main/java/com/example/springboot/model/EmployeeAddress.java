package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_employee_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private long id;
	
	@NotEmpty(message =" Address Cannot be Empty")
	@Column(name="address_name")
	private String addressName;
	
	@NotEmpty(message =" pinCode Cannot be Empty")
	@Column(name="pin_code")
	private String pinCode;


}
