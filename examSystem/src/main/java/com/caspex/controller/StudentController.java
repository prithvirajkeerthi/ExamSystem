package com.caspex.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caspex.model.Student;
import com.caspex.repository.StudentDao;
import com.caspex.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;
	
	
	
	
	@PostMapping("/students")
	@RolesAllowed("admin-prithvi")
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student){
		
		Student savedStudent= sService.saveStudent(student);
	
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students/{roll}")
	@RolesAllowed("admin-prithvi")
	public Student getStudentByRollNumber(@PathVariable("roll") Integer roll) {
		
		return sService.getStudentByRoll(roll);
		
	}
	
	@GetMapping("/students")
	@RolesAllowed("admin-prithvi")
	public ResponseEntity<List<Student>> getAllStudentsDetails(){
		
		
		List<Student> students= sService.getAllStudents();
		
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/students/{roll}")
	@RolesAllowed("admin-prithvi")
	public Student deleteStudentHandler(@PathVariable("roll") Integer roll){
		
		return sService.deleteStudentByRoll(roll);
		
		
	}
	
	
	@PutMapping("/students")
	@RolesAllowed("admin-prithvi")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student){
		
		Student updatedStudent= sService.updateStudent(student);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
		
		
	}
	
	
	@PutMapping("/students/{roll}")
	@RolesAllowed("admin-prithvi")
	public ResponseEntity<Student> updateStudentMarks(@PathVariable("roll") Integer roll,@RequestParam("marks") Integer marks) {
		
		Student updatedStudent = sService.updateStudentMarks(roll, marks);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	
}
