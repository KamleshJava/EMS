package com.xyz.ems.service;

import java.util.List;

import com.xyz.ems.entity.Employee;

public interface IEmployeeService {
	
	Integer save(Employee employee);
	void update(Employee emp);
	void delete(Integer id);
	
	List<Employee> getAllEmployees();
	
	Employee getOneEmployee(Integer id);
}
