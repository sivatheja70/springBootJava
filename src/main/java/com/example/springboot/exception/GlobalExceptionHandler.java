package com.example.springboot.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 /*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody@ExceptionHandler(MethodArgumentNotValidException.class)
    public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }
   
   	private Error processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
       
   		Error error = new Error("Validation Error", HttpStatus.BAD_REQUEST.toString(),null);
   		fieldErrors.forEach(fieldError -> {
   			error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage(),"400");
   		});
      /* for (org.springframework.validation.FieldError fieldError: fieldErrors) {
           error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage(),"400");
       }
       List<FieldError> errorList =  error.getFieldErrors();
   		fieldErrors.forEach(fieldError -> {
   			errorList.add(fieldError);
   		});
       */
      // return error;
  // }
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
	
   	@ExceptionHandler({ ConstraintViolationException.class })
   	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
   	    List<String> errors = new ArrayList<String>();
   	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
   	        errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
   	    }

   	 ResponseMessage apiError =  new ResponseMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
   	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
   	}
}
	