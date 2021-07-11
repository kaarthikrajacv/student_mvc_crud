package com.jpa.example.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jpa.example.error.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired StudentRepository studentRepo;

	@Override
	public List<Student> findAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student findStudentById(Long id) throws Exception {
		
		Optional<Student> student = studentRepo.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}
		else if(!student.isPresent()){
			throw new StudentNotFoundException("Student Not Found");
		}
		return null;
	}

	@Override
	public Student saveStudent(Student student) {
		
		
		return studentRepo.save(student);
		
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		
		Student dbStudent = studentRepo.findById(id).get();
		
		dbStudent.setEmail(student.getEmail());
		dbStudent.setFirstName(student.getFirstName());
		
		dbStudent.setLastName(student.getLastName());
		return studentRepo.save(dbStudent);
		
	}

	@Override
	public void deleteStudent(Long id) {
		
	
		studentRepo.deleteById(id);
		
	}

	@Override
	public Student findByEmail(String email) {
		// TODO Auto-generated method stub
		
		Student student = studentRepo.findByEmail(email);
		System.out.println("The student is " + student);
		
		return student;
	}
	

}
