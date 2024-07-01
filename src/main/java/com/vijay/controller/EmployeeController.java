package com.vijay.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.model.Employee;
import com.vijay.repository.EmployeeRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "EmployeeController", description = "To perform operations on Employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	//record insert into DB
	@Operation(
			summary = "POST operations on Employees",
			description = "It is used to save Employee Object in Database"
			)
	@PostMapping("/employees")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee ctreated in database..";
	}
	
	// get/retrieve record from DB
	@Operation(
			summary = "GET operations on Employees by using employee id",
			description = "It is used to Retrieve Employee Object from Database"
			)
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empid) {
		Optional<Employee> emp = employeeRepository.findById(empid);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	
		
		
	}
	
	//delete record from DB"
	@Operation(
			summary = "DELETE operations on Employees by using employee id",
			description = "It is used to DELETE Employee Object from Database"
			)
	@DeleteMapping("/employees/{empid}")
	public String deleteEmployeeByEmpId(@PathVariable Long empid) {
		employeeRepository.deleteById(empid);
		return "Employee deleted succefully!!!";
		
	}

}
