package com.example.springboot.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@NotNull
	@Size(min = 4, message = "User Name should have atleast 2 character")
	private String username;
	@NotNull
	@Size(min = 4, message = "Password should have atleast 2 character")
	private String password;
	@NotNull
	@Size(min = 4, message = "User Role should have atleast 2 character")
	private String role;
	
	
}