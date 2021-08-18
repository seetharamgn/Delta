package io.seetharam.studentApp.hello;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student")
public class Student {
	
	@Id
	private String id;
	private String roll_number;
	private String student_name;
	private String email;
	private Long phone;
	private String address;
	private String father_name;
	private String section;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoll_number() {
		return roll_number;
	}
	public void setRoll_number(String roll_number) {
		this.roll_number = roll_number;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
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
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Student(String id, String roll_number, String student_name, String email, Long phone, String address,
			String father_name, String section) {
		super();
		this.id = id;
		this.roll_number = roll_number;
		this.student_name = student_name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.father_name = father_name;
		this.section = section;
	}
	
	
}
