package com.simon.service;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.simon.entity.Student;

@Repository
public interface StuService {
	public boolean  saveStudent(Student s);
public List<Student>getAllStudents();
public void delete(Integer sid);
}
