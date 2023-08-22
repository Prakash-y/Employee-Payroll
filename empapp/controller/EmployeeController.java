package com.employeeapplication.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapplication.empapp.dto.EmployeeDTO;
import com.employeeapplication.empapp.dto.ResponseDTO;
import com.employeeapplication.empapp.model.EmployeeModel;
import com.employeeapplication.empapp.service.EmployeeInterface;

import jakarta.validation.Valid;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeInterface service;
	
	@PostMapping("/insert")
	public ResponseEntity<ResponseDTO> insertingEmployee(@Valid @RequestBody EmployeeDTO model)
	{
		EmployeeModel user = service.addingEmployee(model);
		ResponseDTO response = new ResponseDTO(user,"User added succesfully!");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<ResponseDTO> getAllEmployee()
	{
		List<EmployeeModel> allEmployee = service.displayAllEmployee();
		ResponseDTO response = new ResponseDTO(allEmployee,"List of employees!");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable int id) {
		EmployeeModel searchById = service.getEmpById(id);
		ResponseDTO response = new ResponseDTO(searchById,"Employee by ID.");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable int id)
	{
		String delete = service.deleteEmployee(id);
		ResponseDTO response = new ResponseDTO(delete,"deleting by id!");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateById/{id}")
	public  ResponseEntity<ResponseDTO> updateEmployeeById(@PathVariable int id, @Valid  @RequestBody EmployeeDTO model)
	{
		EmployeeModel user = service.updateById(id, model);
		ResponseDTO response = new ResponseDTO(user,"Update employee details by id");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<ResponseDTO> getEmployeeByName(@PathVariable String name) {
		EmployeeModel searchByName = service.getEmpByName(name);
		ResponseDTO response = new ResponseDTO(searchByName,"Employee by Name.");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/byDepartment/{department}")
    public ResponseEntity<ResponseDTO> deptByName(@PathVariable String department)
    {
    	List<EmployeeModel> user = service.deptByEmployeeName(department);
    	ResponseDTO response = new ResponseDTO(user,"User by department");
    	return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
    }
	
	
}
