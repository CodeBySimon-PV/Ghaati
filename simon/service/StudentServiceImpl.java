package com.simon.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.simon.entity.Student;
import com.simon.dao.StudentRepository;

@Service
public class StudentServiceImpl implements StuService {
private StudentRepository sr;
private StudentEmailService sems;

   public StudentServiceImpl(StudentRepository sr,StudentEmailService sems) {
	this.sr=sr;
	this.sems=sems;
}

	@Override
	public boolean saveStudent(Student s) {
		Student stu=sr.save(s);
		return stu.getSid() !=null;
	}

	@Override
	public List<Student> getAllStudents() {
		return sr.findAll();
	}

	@Override
	public void delete(Integer sid) {
		sr.deleteById(sid);
	}
	
	public boolean sendMail(String email,Student s) {
		String subject="hello";
		String body="C:\\Users\\SHARLY\\Pictures\\Screenshots";
		sems.sendMail2(subject, body, s.getEmail());
		return true;
		
	}
}