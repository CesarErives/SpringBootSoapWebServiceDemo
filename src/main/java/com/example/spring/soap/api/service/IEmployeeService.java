package com.example.spring.soap.api.service;

import com.example.spring.soap.api.model.Employee;

public interface IEmployeeService {
	void AddEmployee(Employee employee);
	
	Employee getEmployeeById(long employeeId);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(long employeeId);
}
