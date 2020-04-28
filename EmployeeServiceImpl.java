package com.nikhilknn.springboot.myspringcruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikhilknn.springboot.myspringcruddemo.dao.EmployeeDAO;
import com.nikhilknn.springboot.myspringcruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO TheemployeeDAO)
	{
		employeeDAO=TheemployeeDAO;
	}
	
	

	@Override
	@Transactional
	public List<Employee> FindAll() {
		// TODO Auto-generated method stub
		
		return employeeDAO.FindAll();
	}

	@Override
	@Transactional
	public Employee FindById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.FindById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void DeleteById(int theId) {
		// TODO Auto-generated method stub
employeeDAO.DeleteById(theId);
	}

}
