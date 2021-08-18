package io.seetharam.studentApp.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectContoller {
	
	@Autowired	
	private SubjectRepository subjectRepository;
	
	@GetMapping("/subject")
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}
	
	@GetMapping("/subject/{id}")
	public Optional<Subject> getSubject(@PathVariable String id) {
		return subjectRepository.findById(id);
	}
	
	@PostMapping("/addsubject")
	public Subject addSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	@PutMapping("/subject/{id}")
	public Subject updateSubject(@RequestBody Subject newsubject, @PathVariable String id){
		return subjectRepository.findById(id).map(
				subject ->{
					subject.setSubject_code(newsubject.getSubject_code());
					subject.setSubject_name(newsubject.getSubject_name());
					subject.setSubject_credit(newsubject.getSubject_credit());
					return subjectRepository.save(subject);
				})
				.orElseGet(() ->{
				newsubject.setSubject_code(id);
                return subjectRepository.save(newsubject);
				});
		
	}
	
	@DeleteMapping("/subject/{id}")
	public ResponseEntity<String> deleteSubject(@PathVariable String id) {
		subjectRepository.deleteById(id);
		 return ResponseEntity.ok().body("Deleted successfully...!");
	}
	
}
