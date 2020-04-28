package com.nikhilknn.springboot.myspringcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nikhilknn.springboot.myspringcruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//define constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager)
	{
     entityManager=theEntityManager;	
	}

	@Override
	public List<Employee> FindAll() {

		
		//get the cureent hibernate session
		Session CurrentSession=entityManager.unwrap(Session.class); 
		
		//create query 
		Query<Employee> theQuery=CurrentSession.createQuery("from Employee",Employee.class);
		
		//execute the query
		List<Employee> employees=theQuery.getResultList();
		
		//get result
		
		return employees;
	}

	@Override
	public Employee FindById(int theId) {
		
		//get the current hibernate session
		Session CurrentSession=entityManager.unwrap(Session.class);
		
		
		//get the employee by id
		
		Employee theEmployee=CurrentSession.get(Employee.class, theId);
		
		//return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Session CurrentSession=entityManager.unwrap(Session.class);
		
		//save the emplouee
		
		CurrentSession.saveOrUpdate(theEmployee);
		
		
		
		
	}

	@Override
	public void DeleteById(int theId) {
	
		Session CurrentSession=entityManager.unwrap(Session.class);
		
		//delte the object with primary key
		
		Query<Employee> theQuery=CurrentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
