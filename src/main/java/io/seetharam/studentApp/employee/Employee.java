package io.seetharam.studentApp.employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Employee")
public class Employee {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String department;
	private String designation;
	private String address;
	private Long phone;
	private String employee_type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}
	public Employee(String id, String name, String email, String department, String designation, String address,
			Long phone, String employee_type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.designation = designation;
		this.address = address;
		this.phone = phone;
		this.employee_type = employee_type;
	}
	
	

}
