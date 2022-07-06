package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Emp;
import com.example.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo Emprepo;
	
	public void addEmployee(Emp e) {
		
		Emprepo.save(e);
		
	}
	
	public List<Emp> getAllEmployee(){
		
		return Emprepo.findAll();
	}
	
	public Emp getEmployeeById(Long id) {
		 Optional<Emp> e= Emprepo.findById(id);
		 
		 if(e.isPresent())
		 {
			 return e.get();
		 }
		 return null;
	}

	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
		Emprepo.deleteById(id);
	}
}
