package io.seetharam.studentApp.hello;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//REquset controller convert the normal class to request controller
@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/student")
	public List<Student> getStudent() {
		return studentRepository.findAll();
	}
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudentbyid(@PathVariable String id) {
		return studentRepository.findById(id);
	}
	@PutMapping("/student/{id}")
	public Student updateStudent(@RequestBody Student newStudent, @PathVariable String id) {
		return studentRepository.findById(id).map(
				student-> {
					student.setRoll_number(newStudent.getRoll_number());
					student.setStudent_name(newStudent.getStudent_name());
					student.setEmail(newStudent.getEmail());
					student.setAddress(newStudent.getAddress());
					student.setFather_name(newStudent.getFather_name());
					student.setPhone(newStudent.getPhone());
					student.setSection(newStudent.getSection());
					return studentRepository.save(student);
				})
				.orElseGet(() ->{
				newStudent.setId(id);
				return studentRepository.save(newStudent);
				});
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable String id) {
		studentRepository.deleteById(id);
		 return ResponseEntity.ok().body("Deleted successfully...!");
	}
	
	
	
	

}
