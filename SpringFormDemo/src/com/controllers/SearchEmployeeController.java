package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Employee;

@Controller
public class SearchEmployeeController {

	@RequestMapping(method = RequestMethod.GET , value="searchEmployees.htm")
	public ModelAndView searchByTechnology(@RequestParam String technology) {
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(111, "John Cena", 7000, "java"));
		employees.add(new Employee(112, "Mike", 8003, "java"));
		employees.add(new Employee(114, "Siri", 19907, "java"));
		
		ModelAndView modelAndView = new ModelAndView("display" , "employees" , employees);
		
		
		return modelAndView;
	}
	
	
}
