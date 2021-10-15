package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.dto.EmployeeDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
public class Employee {
	@Id
	private int id;
	private String name;	
	private int salary;
	
	
	
	public Employee(int id, EmployeeDTO employeeDTO) {
		super();
		this.id = id;
		this.name = employeeDTO.getName();
		this.salary = employeeDTO.getSalary();
	}
	
	
	
	
}
