package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data public class EmployeeDTO {

	@Pattern(regexp = "^[A-Z][a-z]{2,}$", message= "Name Not In Format")
	private String name;
	@Min(value = 1000, message="Base salaryshould be more 1000!")
	private int salary;
	
	public EmployeeDTO(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}	
}
