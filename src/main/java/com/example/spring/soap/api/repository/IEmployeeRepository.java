package com.example.spring.soap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.soap.api.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByEmployeeId(long employeeId);
 
}
