package com.employeeapplication.empapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {

	private String message;
	
	private Object data;
	
	public ResponseDTO(Object data, String message)
	{
		this.message = message;
		this.data = data;
	}
}
