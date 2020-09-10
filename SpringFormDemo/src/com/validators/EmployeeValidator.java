package com.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pojo.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> emp_class) {
		// TODO Auto-generated method stub
		return emp_class.equals(Employee.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		Employee employee = (Employee) obj;

		if (employee.getName().length() <= 5) {

			errors.rejectValue("name", "EmployeeName.required", "Please enter the name");
		}

		if (employee.getEmpId()<100) {

			errors.rejectValue("empId", "empId.required", "Please enter a valid ID");
		}
		

		if (employee.getSalary()<=3000) {

			errors.rejectValue("salary", "salary.required", "Please enter a valid Salary");
		}


		
		 
	}

}
