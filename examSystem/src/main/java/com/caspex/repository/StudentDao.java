package com.caspex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caspex.model.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}

