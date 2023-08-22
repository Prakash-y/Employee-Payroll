package com.employeeapplication.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapplication.empapp.dto.EmployeeDTO;
import com.employeeapplication.empapp.exception.EmployeeNotFoundException;
import com.employeeapplication.empapp.exception.IdNotFoundException;
import com.employeeapplication.empapp.model.EmployeeModel;
import com.employeeapplication.empapp.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeInterface{

	@Autowired
	 private EmployeeRepository employeeRepository;
	
	
	@Override
	public EmployeeModel addingEmployee(EmployeeDTO model) {
		EmployeeModel user = new EmployeeModel(model);
		employeeRepository.save(user);
		return user;
	}

	@Override
	public List<EmployeeModel> displayAllEmployee() {
		return employeeRepository.findAll();
		
	}

	@Override
	public EmployeeModel getEmpById(int id) {
		Optional<EmployeeModel> user = employeeRepository.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			throw new EmployeeNotFoundException("Employee id not found!");
		}
		
	}

	@Override
	public String deleteEmployee(int id)
	{
		Optional<EmployeeModel> user = employeeRepository.findById(id);
		if(user.isPresent())
		{
			employeeRepository.deleteById(id);
			return "Deleted Succefully!";
		}
		else {
			new EmployeeNotFoundException("Employee Not Found");
		}
		return null;
	}

	@Override
	public EmployeeModel updateById(int id, EmployeeDTO model) 
	{
		EmployeeModel empModel = employeeRepository.findById(id).get();
		if(empModel != null)
		{
		empModel.setName(model.getName());
		empModel.setGender(model.getGender());
		empModel.setStartdate(model.getStartdate());
		empModel.setSalary(model.getSalary());
		empModel.setDepartment(model.getDepartment());
		employeeRepository.save(empModel);
		return empModel;
		}
		else
		{
			new IdNotFoundException("Employee not found ");
		}
		return null;
	}

	@Override
	public EmployeeModel getEmpByName(String name) {
		
		Optional<EmployeeModel> user = employeeRepository.findByName(name);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			throw new IdNotFoundException("Employee not found!");
		}
		
	}

	@Override
	public List<EmployeeModel> deptByEmployeeName(String department) {
		List<EmployeeModel> user = employeeRepository.findAllByDept(department);
		return user;
	}

	

	
}
