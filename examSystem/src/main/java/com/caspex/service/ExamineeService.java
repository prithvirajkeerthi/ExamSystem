
//to add some functionality to examinee, created service interface

package com.caspex.service;

import org.springframework.http.ResponseEntity;

import com.caspex.exception.ExamineeException;
import com.caspex.model.Examinee;
import com.caspex.model.Student;

public interface ExamineeService {


//	i need to expose this service to controller

	public Examinee saveExaminee(Examinee examinee);
	public Examinee getExamineeByRoll(Integer roll) throws ExamineeException;
	public Examinee deleteExamineeByRoll(Integer roll) throws ExamineeException;
//	public Examinee updateExamineeMarks(Integer roll, Integer graceMarks) throws ExamineeException;
	public Examinee updateExaminee(Examinee examinee) throws ExamineeException;
	
	
}
