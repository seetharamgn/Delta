package io.seetharam.studentApp.teacher;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher {
	
	@Id
	private String id;
	private String name;
	private String department;
	private String email;
	private Long phone;
	private String address;
	private String designation;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}
	public Teacher(String id, String name, String department, String email, Long phone, String address,
			String designation, String employee_type) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.designation = designation;
		this.employee_type = employee_type;
	}
	
	
}
