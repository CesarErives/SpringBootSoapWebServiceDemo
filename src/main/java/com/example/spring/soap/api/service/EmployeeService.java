package com.example.spring.soap.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import com.example.spring.soap.api.model.Employee;
import com.example.spring.soap.api.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	
	private final IEmployeeRepository employeeRepository;

	public EmployeeService(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public void AddEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee getEmployeeById(long employeeId) {
		
		return Optional.ofNullable(employeeRepository.findByEmployeeId(employeeId)).orElse(null);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}
	
}
