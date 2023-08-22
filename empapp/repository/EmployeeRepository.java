package com.employeeapplication.empapp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapplication.empapp.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
   
	@Query(value="Select * from employees where name =:name",nativeQuery = true)
	Optional<EmployeeModel> findByName(String name);

	@Query(value="Select * from employees,emp_department where employee_id=did and department=:department",nativeQuery = true)
	List<EmployeeModel> findAllByDept(String department);

	
}
