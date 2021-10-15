package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeServ;

	/**
	 * This will give the emp data of the paticular id; and return the
	 * ResponseEntity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getDataEmp(@PathVariable int id) {
		Employee emp = employeeServ.get(id);
		ResponseDTO resposneDTO = new ResponseDTO("Data is :", emp);
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}

	/**
	 * will show All the Employee data; return ResponseEntity
	 */
	@GetMapping("/")
	public ResponseEntity<ResponseDTO> getAllEmpData() {
		List<Employee> empList = employeeServ.getall();
		ResponseDTO resposneDTO = new ResponseDTO("Total List", empList);
		log.info("Its Up And Running");
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}

	/**
	 * post call user has to send all the data to save in list/db; * return
	 * ResponseEntity
	 */
	@PostMapping(path = "/addemp")
	public ResponseEntity<ResponseDTO> post(@Valid @RequestBody EmployeeDTO employeeDTO) {
		ResponseDTO resposneDTO = new ResponseDTO("Added successfully", employeeServ.add(employeeDTO));
		log.info("Its Up And Running");
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}

	/**
	 * will ask for the id and delete the data; input id return ResponseEntity
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable int id) {
		ResponseDTO resposneDTO = new ResponseDTO("Deleted!", employeeServ.delete(id));
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> update(@PathVariable("id") int id, @RequestBody EmployeeDTO employeeDTO) {
		ResponseDTO resposneDTO = new ResponseDTO("Updated!", employeeServ.update(id, employeeDTO));
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}

}
