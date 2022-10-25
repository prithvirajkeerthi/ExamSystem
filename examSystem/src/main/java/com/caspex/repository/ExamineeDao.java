package com.caspex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caspex.model.Examinee;

//give the entity object and the datatype of id of that entity to jparepo interface

@Repository
public interface ExamineeDao extends JpaRepository<Examinee, Integer> {

}


//here we not need to implement this interface,spring data jpa internally implements this interface
//as a spring bean and will register with spring container