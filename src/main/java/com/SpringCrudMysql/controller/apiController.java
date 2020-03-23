package com.SpringCrudMysql.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCrudMysql.controller.model.studentModel;
import com.SpringCrudMysql.exception.ResourceNotFoundException;
import com.SpringCrudMysql.repo.studentRepo;

@RestController
@RequestMapping("/api")
public class apiController {
	@Autowired
	studentRepo repo;
	
	
	@PostMapping("/addStudent")
	public studentModel addStudent(@RequestBody studentModel studentData) {
		System.out.println("addStudent_data"+studentData);
		return repo.save(studentData);
	}
	
	@GetMapping("/getStudent/{id}")
	public Optional<studentModel> getStudentById(@PathVariable int id) {
		System.out.println("getAllStudent" + id);
		return repo.findById(id);
	}
	
	@PutMapping("/updateStudent/{id}")
	public studentModel updateStudent(@PathVariable int id,@Valid @RequestBody studentModel studetDetails) throws ResourceNotFoundException {
		System.out.println("studetDetails"+studetDetails);
		studentModel student= repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " +id));
		student.setName(studetDetails.getName());
		student.setTitle(studetDetails.getTitle());
		return repo.save(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable int id) throws ResourceNotFoundException {
		System.out.println("deleteStudent"+id);
		studentModel student= repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " +id));
		
		repo.deleteById(id);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
		return response;
	}
	
	@RequestMapping("/getAllStudent")
	public List<studentModel> getAllStudent() {
		System.out.println("getAllStudent");
		return repo.findAll();
	}
	
	@RequestMapping("/test")
	public String testApi() {
		System.out.println("test api tested");
		return "String";
	}

}
