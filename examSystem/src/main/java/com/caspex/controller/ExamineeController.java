package com.caspex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caspex.model.Examinee;
import com.caspex.model.Student;
import com.caspex.service.ExamineeService;

@RestController
public class ExamineeController {

	
	@Autowired
	private ExamineeService exservice;
	
	@PostMapping("/examinees")
	public ResponseEntity<Examinee> saveExamineeHandler(@RequestBody Examinee examinee)
	{
Examinee savedExaminee=exservice.saveExaminee(examinee);
return new ResponseEntity<Examinee>(savedExaminee,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/examinees/{roll}")
	public Examinee getStudentByRollNumber(@PathVariable("roll") Integer roll) {
		
		return exservice.getExamineeByRoll(roll);
		
	}
	@DeleteMapping("/examinees/{roll}")
	public Examinee deleteStudentHandler(@PathVariable("roll") Integer roll){
		
		return exservice.deleteExamineeByRoll(roll);
			
	}
	
	@PutMapping("/examinees")
	public ResponseEntity<Examinee> updateStudentHandler(@RequestBody Examinee examinee){
		
		Examinee updatedExaminee= exservice.updateExaminee(examinee);
		
		return new ResponseEntity<Examinee>(updatedExaminee,HttpStatus.ACCEPTED);
		
		
	}
	
}
