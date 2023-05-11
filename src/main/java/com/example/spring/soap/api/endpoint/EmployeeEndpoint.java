package com.example.spring.soap.api.endpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.spring.soap.api.service.IEmployeeService;
import com.example.spring.soap.api.model.Employee;
import api.soap.spring.example.com.AddEmployeeRequest;
import api.soap.spring.example.com.AddEmployeeResponse;
import api.soap.spring.example.com.DeleteEmployeeRequest;
import api.soap.spring.example.com.DeleteEmployeeResponse;
import api.soap.spring.example.com.GetEmployeeByIdRequest;
import api.soap.spring.example.com.GetEmployeeByIdResponse;
import api.soap.spring.example.com.ServiceStatus;
import api.soap.spring.example.com.UpdateEmployeeRequest;
import api.soap.spring.example.com.UpdateEmployeeResponse;
import api.soap.spring.example.com.EmployeeInfo;

@Endpoint
public class EmployeeEndpoint {
	
	private static final String NAMESPACE_URI = "http://com.example.spring.soap.api";
	
	private final IEmployeeService employeeService;
	
	public EmployeeEndpoint(IEmployeeService employeeService){
		this.employeeService = employeeService;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.AddEmployee(employee);
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		return response;	
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeByIdResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()),employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		ServiceStatus serviceStatus = new ServiceStatus();
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.updateEmployee(employee);
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		response.setServiceStatus(serviceStatus);
		return response;
	}
	
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
		employeeService.deleteEmployee(request.getEmployeeId());
		ServiceStatus serviceStatus = new ServiceStatus();
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Deleted Successfully");
		response.setServiceStatus(serviceStatus);
		return response;

	}

}
