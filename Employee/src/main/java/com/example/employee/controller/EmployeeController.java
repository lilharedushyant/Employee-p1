package com.example.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.employee.entity.Emp;
import com.example.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String home(Model m) 
	{
		List<Emp>employee=service.getAllEmployee();
		m.addAttribute("employee",employee);
		
		return "index";
		
	}

	@GetMapping("/add_employee")
	public String addEmployeeForm()
	{
		System.out.println("save");
		return "add_employee";
	}
	
	@PostMapping("/register")
	public String employeeRegister(@ModelAttribute Emp e, HttpSession session )
	{
		System.out.println(e);
		
		service.addEmployee(e);
		
		session.setAttribute("msg", "Employee Added Successfully..");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model m) {
		
		Emp e=service.getEmployeeById(id);
		m.addAttribute("employee",e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Emp e, HttpSession session) {
		
		service.addEmployee(e);
		session.setAttribute("msg", "Employee Update Successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id, HttpSession session) {
		
		service.deleteEmployee(id);
		session.setAttribute("msg", "Employee Deleted Successfully..");
		return "redirect:/";
	}

}

