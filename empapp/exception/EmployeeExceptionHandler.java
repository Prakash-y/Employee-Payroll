package com.employeeapplication.empapp.exception;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.employeeapplication.empapp.dto.ResponseDTO;

@ControllerAdvice
public class EmployeeExceptionHandler {
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
	   MethodArgumentNotValidException exception){
	  List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
	  List<String> errMsg = errorList.stream()
	    .map(objErr -> objErr.getDefaultMessage())
	    .collect(Collectors.toList());
	  ResponseDTO response = new ResponseDTO("Exception while processing REST Request",exception.getMessage());
	  return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(EmployeeException.class)
	 public ResponseEntity<ResponseDTO> handleEmployeeApplicationException(
	   EmployeeException exception){
	  ResponseDTO response = new ResponseDTO("Exception while processing REST Request",
	    exception.getMessage());
	  return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	 }

	}

