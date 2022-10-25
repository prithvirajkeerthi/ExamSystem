package com.caspex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caspex.exception.ExamineeException;
import com.caspex.exception.StudentException;
import com.caspex.model.Examinee;
import com.caspex.model.Student;
import com.caspex.repository.ExamineeDao;

//to make it spring bean class
@Service
public class ExamineeServiceImpl implements ExamineeService{
	
//	implementaion given by springdata jpa of examineedao interface will be injected here,using this
//	interface we can persist our examinee
	
	
	@Autowired
	private ExamineeDao exDao;

@Override
public Examinee saveExaminee(Examinee examinee) {
	
		Examinee savedExaminee=exDao.save(examinee);
		return savedExaminee;

}

@Override
public Examinee getExamineeByRoll(Integer roll) throws ExamineeException {
	
	return exDao.findById(roll).orElseThrow(()->new ExamineeException("NO examinees present with"+roll));
	
}

@Override
public Examinee deleteExamineeByRoll(Integer roll) throws ExamineeException {
	
	Examinee existingExaminee=exDao.findById(roll).orElseThrow(()->new ExamineeException("No examiness present with"+roll));
	exDao.delete(existingExaminee);
	return existingExaminee;
}

@Override
public Examinee updateExaminee(Examinee examinee) throws ExamineeException {
	
	
	Optional<Examinee> opt=exDao.findById(examinee.getRoll());
	
	if (opt.isPresent()) {
		
		Examinee existingExaminee=opt.get();
		
		return exDao.save(examinee);
		
		
	} else {

		throw new ExamineeException("Invalid Examinee Details");
	}
}


//@Override
//public Student updateExamineeMarks(Integer roll, String name) throws ExamineeException {
//	
//	Optional<Examinee> opt= exDao.findById(roll);
//	
//	if(opt.isPresent()) {
//		
//		Examinee existingExaminee= opt.get();
//		
//		
//		existingExaminee.setMarks(existingExaminee.getMarks()+graceMarks);
//		
//		return sDao.save(existingStudent);
//		
//		
//	}else
//		throw new StudentException("Student does not exist with Roll :"+roll);
//	
//	
//}
	
	

}
