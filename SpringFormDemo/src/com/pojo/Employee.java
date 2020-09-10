package com.pojo;

public class Employee {
	private int empId, salary;
	private String name, technology;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId,  String name, int salary ,  String technology) {
		super();
		this.empId = empId;
		this.salary = salary;
		this.name = name;
		this.technology = technology;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnoogy(String technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", salary=" + salary + ", name=" + name + ", technology=" + technology + "]";
	}

}
