package com.example.demo.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	
	EmployeeRepo emprepo;
	private List<Employee> employeeList = new ArrayList<>();
	
	public Employee get(int id) {
		return emprepo.getById(id);
	}
	
	public List<Employee> getall(){
		return emprepo.findAll();
	}
	
	public Employee add(EmployeeDTO employeeDTO) {
		Employee employee= new Employee(employeeList.size()+1, employeeDTO);
		emprepo.save(employee);
		return employee;
	}
	
	public List<Employee> update(int id, EmployeeDTO employeeDTO) {
		Employee employee= employeeList.get(id-1);
		employee.setName(employeeDTO.getName());
		employee.setSalary(employeeDTO.getSalary());
		
		employeeList.set(id-1, employee);
		return employeeList;
	}
	
	public List<Employee> delete(int id) {
		emprepo.deleteById(id);
		return emprepo.findAll();
	}
}
