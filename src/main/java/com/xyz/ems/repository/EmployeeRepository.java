package com.xyz.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.ems.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
