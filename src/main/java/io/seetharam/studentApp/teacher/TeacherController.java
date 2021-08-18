package io.seetharam.studentApp.teacher;

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





@RestController
public class TeacherController {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@GetMapping("/teacher")
	public List<Teacher> getTeacher(){
		return teacherRepository.findAll();
	}
	
	@PostMapping("addteacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@GetMapping("/teacher/{id}")
	public  Optional<Teacher> getTeacherbyId(@PathVariable String id){
		return teacherRepository.findById(id);
	}
	
	@PutMapping("/teacher/{id}")
	public Teacher updateTeacher(@RequestBody Teacher newTeacher, @PathVariable String id) {
		return teacherRepository.findById(id).map(
				teacher-> {
					teacher.setId(newTeacher.getId());
					teacher.setName(newTeacher.getName());
					teacher.setDepartment(newTeacher.getDepartment());
					teacher.setAddress(newTeacher.getAddress());
					teacher.setDesignation(newTeacher.getDesignation());
					teacher.setEmail(newTeacher.getEmail());
					teacher.setEmployee_type(newTeacher.getEmployee_type());
					teacher.setPhone(newTeacher.getPhone());
					return teacherRepository.save(teacher);
				})
				.orElseGet(() ->{
				newTeacher.setId(id);
				return teacherRepository.save(newTeacher);
				});
	}
	
	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable String id) {
		teacherRepository.deleteById(id);
		return ResponseEntity.ok().body("Deleted successfully...!");
	}
}
