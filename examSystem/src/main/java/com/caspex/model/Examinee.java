package com.caspex.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//controller--> service layer ---> data Access layer



@Entity
public class Examinee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	creates id automatically
	private Integer roll;
	private String name;
	private String gender;
	private String classStudy;
	
	public Examinee() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClassStudy() {
		return classStudy;
	}

	public void setClassStudy(String classStudy) {
		this.classStudy = classStudy;
	}

	public Examinee(Integer roll, String name, String gender, String classStudy) {
		super();
		this.roll = roll;
		this.name = name;
		this.gender = gender;
		this.classStudy = classStudy;
	}
	
	
	

}
