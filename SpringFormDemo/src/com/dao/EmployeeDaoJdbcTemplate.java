package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pojo.Employee;


@Repository(value="template")
public class EmployeeDaoJdbcTemplate implements EmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	@Override
	public int addEmployee(Employee employee) {
		
		String insertData = "insert into employee values(?,?,?,?)";
		int added = 0 ;
		
		added = jdbcTemplate.update(insertData , employee.getEmpId() , employee.getName() , employee.getSalary() , employee.getTechnology());
		
		return added;
	}

	@Override
	public int addEmployee1(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		boolean updated = false;
		String updateData = "update employee set salary = ? , technology = ?  where empid = ?";
		
		int num = jdbcTemplate.update(updateData , employee.getSalary() , employee.getTechnology() , employee.getEmpId());
		
		if(num > 0) {
			updated = true;
		}
		
		
		return updated;
	}

	@Override
	public int deleteEmployee(int empId) {
		int deleted = 0;
		String deleteData = "delete from employee where empid = ?";
		
		deleted = jdbcTemplate.update(deleteData , empId);
	
		
		
		return deleted;
	}

	@Override
	public Employee findEmployeeById(int empId) {
      
		Employee employee = null;
		String findData = "Select * from employee where empid = ?";
		
		employee = jdbcTemplate.queryForObject(findData , new Integer[] {empId} , new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet set, int arg1) throws SQLException {
				
				Employee emp = new Employee();
				emp.setEmpId(set.getInt(1));
				emp.setName(set.getString(2));
				emp.setSalary(set.getInt(3));
				emp.setTechnoogy(set.getString(4));
				return emp;
			}
			
			
		});

		return employee;
	}

	@Override
	public List<Employee> findAllEMployees() {
		List<Employee> employees = jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet set, int arg1) throws SQLException {
				
				Employee emp = new Employee();
				emp.setEmpId(set.getInt(1));
				emp.setName(set.getString(2));
				emp.setSalary(set.getInt(3));
				emp.setTechnoogy(set.getString(4));
				return emp;
			}
			
			
		});
		
		return employees;
	}

}
