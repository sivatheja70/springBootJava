package com.example.springboot.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
	private String message;
	private String status;
	
	 private List<FieldError> fieldErrors = new ArrayList<>();
	 
	 public void addFieldError(String fieldName,String msg, String status) {
         FieldError error = new FieldError(fieldName,msg, status);
         fieldErrors.add(error);
     }
	 
}
