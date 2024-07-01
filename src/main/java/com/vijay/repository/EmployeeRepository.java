package com.vijay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
