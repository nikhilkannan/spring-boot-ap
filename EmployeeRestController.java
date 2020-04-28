package com.nikhilknn.springboot.myspringcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhilknn.springboot.myspringcruddemo.entity.Employee;
import com.nikhilknn.springboot.myspringcruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;

	//quick and direct injection of dao
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService)
	{
		employeeService=theEmployeeService;
	}
	
	//expose "employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> FindAll()
	{return employeeService.FindAll();
		
	}
	
	//add mapping to get employee/employeeid
	
	@GetMapping("/employees/{employeeid}")
	public Employee GetEmployee(@PathVariable int employeeid)
	{
		Employee theEmployee=employeeService.FindById(employeeid);
		
		if(theEmployee==null)
		{
			throw new RuntimeException("id doesnt exist");
		}
		
		return theEmployee;
	}
	
	//add mapping to create an employee
	
	@PostMapping("/employees")
	public Employee AddEmployee(@RequestBody Employee theEmployee)
	{
		//in case as id is auto generated so if anyone passes id then it will auto set tp 0
		//it will force an item to insert it instead of update
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		
		return theEmployee;
		
		
	}
	
	//add mapping for updating an employee
	
	@PutMapping("/employees")
	public Employee UpdateEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping for deleting an employee
	@DeleteMapping("/employees/{employeeId}")
	public String DeleteEmployee(@PathVariable int employeeId)
	{
		Employee tempEmployee=employeeService.FindById(employeeId);

		if(tempEmployee==null)
		{
			throw new RuntimeException("id doesnt exist");
		}
		
		
		employeeService.DeleteById(employeeId);
		return "employee with id"+employeeId + "deleted";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
