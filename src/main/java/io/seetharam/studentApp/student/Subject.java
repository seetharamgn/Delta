package io.seetharam.studentApp.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="rama")
public class Subject {
	@Id
	private String id;
	private  String subject_name;
	private String subject_code;
	private String subject_credit;
	
	public Subject() {
		super();
	}
	
	public Subject(String subject_name, String subject_code, String subject_credit) {
		super();
		this.subject_name = subject_name;
		this.subject_code = subject_code;
		this.subject_credit = subject_credit;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}
	public String getSubject_credit() {
		return subject_credit;
	}
	public void setSubject_credit(String subject_credit) {
		this.subject_credit = subject_credit;
	}
	
	

}
