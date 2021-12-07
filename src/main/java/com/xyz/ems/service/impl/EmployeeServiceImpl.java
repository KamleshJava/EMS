package com.xyz.ems.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xyz.ems.entity.Employee;
import com.xyz.ems.exception.EmployeeNotFoundException;
import com.xyz.ems.repository.EmployeeRepository;
import com.xyz.ems.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Integer save(Employee employee) {
		employee = employeeRepository.save(employee);
		Integer id = employee.getId();
		
		return id;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeeRepository.findAll();
		
		return list;
	}
	
	@Override
	public void update(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public void delete(Integer id) {
		// get the employee by id if employee is exist with id get the emp obj and pass to the delete method
		//employeeRepository.deleteById(id);
		
			employeeRepository.delete(getOneEmployee(id));
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Employee e = null;
		
		Optional<Employee> optional = employeeRepository.findById(id);
		
		if(optional.isPresent()) {
			e = optional.get();
		}else {
			throw new EmployeeNotFoundException("Employee Not Exist with ID : "+id);
		}
		
		return e;
	}


}











