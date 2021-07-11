package com.jpa.example.student;

import java.util.List;

public interface StudentService {
	
	public List<Student> findAllStudents();

	public Student findStudentById(Long id) throws Exception;
	
	public Student saveStudent(Student student);
	
	public Student updateStudent(Long id, Student student);
	
	public void deleteStudent(Long id);
	
	public Student findByEmail(String email);
}
