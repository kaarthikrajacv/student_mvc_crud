package com.jpa.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository  extends JpaRepository<Student, Long>{
	
	@Query(value="select * from student where email=?1", nativeQuery=true)
	public Student findByEmail(String email);

}
