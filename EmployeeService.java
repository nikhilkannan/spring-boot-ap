package com.nikhilknn.springboot.myspringcruddemo.service;

import java.util.List;

import com.nikhilknn.springboot.myspringcruddemo.entity.Employee;

public interface EmployeeService {
public List<Employee> FindAll();
	
	public Employee FindById(int theId);
	
	public void save(Employee theEmployee);
	
	public void  DeleteById(int theId);

}
