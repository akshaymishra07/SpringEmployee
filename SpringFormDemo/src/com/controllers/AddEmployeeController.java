package com.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.EmployeeDAO;
import com.pojo.Employee;

@Controller
public class AddEmployeeController {
  
	@Autowired 
	EmployeeDAO dao;
	
	@RequestMapping("/showEmployeeForm.htm")
	public ModelAndView showEmployeeForm(ModelMap map) throws Exception{
		
		Employee employee= new Employee();
		map.addAttribute(employee);
		return new ModelAndView("employeeForm");
	}
	
	@RequestMapping(method=RequestMethod.POST , value="addEmployee.htm")
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
		List<Employee> employees= new ArrayList<>();
		employees.add(employee);
		modelAndView.addObject("employees",employees);
		
		
		return modelAndView;
		
	}
	
	@ModelAttribute("technologyList")
	public List<String> addTech()
	{
		List<String> technologies = new ArrayList<String>();
		technologies.add("JAVA");
		technologies.add(".NET");
		technologies.add("KUBERNETES");
		technologies.add("CLOUD");
		technologies.add("Databases");
		
		return technologies;
	}

	
	@RequestMapping(method=RequestMethod.POST , value="addEmployee_valid.htm")
	public ModelAndView addEmployee_valid(@Valid @ModelAttribute("employee") Employee employee , BindingResult bindingResult) throws Exception {
		
		if(bindingResult.hasErrors()) {
			
			return new 	ModelAndView("employeeForm");
		}
		
		System.out.println(employee);
		
		int added = dao.addEmployee(employee);
		
		if(added != 1) {
			
			return new ModelAndView("employeeForm");
			
		}
		
		List <Employee> employees= dao.findAllEMployees();
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
		
		modelAndView.addObject("employees",employees);
		
		
		return modelAndView;
		
	}
	
	@Autowired
	Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder webDataBinder)
	{
		webDataBinder.setValidator(validator);
	}



}
