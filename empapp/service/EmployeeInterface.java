package com.employeeapplication.empapp.service;

import java.util.List;

import com.employeeapplication.empapp.dto.EmployeeDTO;
import com.employeeapplication.empapp.exception.EmployeeNotFoundException;
import com.employeeapplication.empapp.exception.IdNotFoundException;
import com.employeeapplication.empapp.model.EmployeeModel;

public interface EmployeeInterface {

	List<EmployeeModel> displayAllEmployee(); 

	EmployeeModel getEmpById(int id); 

	String deleteEmployee(int id);

	EmployeeModel updateById(int id, EmployeeDTO model);

	EmployeeModel addingEmployee(EmployeeDTO model);

	EmployeeModel getEmpByName(String name);

	List<EmployeeModel> deptByEmployeeName(String department);


	

	

}
