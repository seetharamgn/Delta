package io.seetharam.studentApp.employee;

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
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employee")
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable String id){
		return employeeRepository.findById(id);
	}
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmloyee(@RequestBody Employee newEmployee, @PathVariable String id){
		return employeeRepository.findById(id).map(
				employee ->{
					employee.setId(newEmployee.getId());
					employee.setName(newEmployee.getName());
					employee.setDepartment(newEmployee.getDepartment());
					employee.setAddress(newEmployee.getAddress());
					employee.setDesignation(newEmployee.getDesignation());
					employee.setEmail(newEmployee.getEmail());
					employee.setEmployee_type(newEmployee.getEmployee_type());
					employee.setPhone(newEmployee.getPhone());
					return employeeRepository.save(employee);
				})
				.orElseGet(() ->{
					newEmployee.setId(id);
					return employeeRepository.save(newEmployee);
					});
				
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable String id) {
		employeeRepository.deleteById(id);
		return ResponseEntity.ok().body("Deleted successfully...!");
	}
}
