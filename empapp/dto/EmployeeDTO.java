package com.employeeapplication.empapp.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
        
	    @Pattern(regexp="^[A-Z]{1}[a-zA-Z]{3,}$", message="Name should be as per standard")
	    private String name;
	    @NotEmpty
		private String gender;
		private Date startdate;
		@Min(value=10000, message="salary should be more than 10000")
		private long salary;
		private String profilepic;
		private List<String> department;
		private String note;
}
