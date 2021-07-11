package com.jpa.example.student;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired StudentService studentService;
	
	@GetMapping("/list")
	public String findAllStudents(Model model) {
		
		//To get Data from DB
		List<Student> students = studentService.findAllStudents();
		
		// Load data into JSP file ..
		model.addAttribute("studentsList", students);
		
		CompletableFuture.runAsync(() ->{
			
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Inside Completable" + Thread.currentThread().getName());
		});
		
		System.out.println("Going to return list" + Thread.currentThread().getName());
		return "student-list";
		
	}
	
	@GetMapping("/{id}")
	public Student findStudentById(@PathVariable Long id) throws Exception {
		
		return studentService.findStudentById(id);
	}
	
	@PostMapping("/createStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		return "redirect:/student/list";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("student") Student student) {
			
		studentService.updateStudent(student.getId(), student);
		return "redirect:/student/list";
		
	}
	
	@GetMapping("/editStudentDetails")
	public String updateStudentDetails(@RequestParam("studentId") Long id, Model model) throws Exception {
		
		Student student = studentService.findStudentById(id);
		
		model.addAttribute("student", student);
		
		return "student-update-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") Long id) {
		
		System.out.println("The delete student is " + id);
		
		studentService.deleteStudent(id);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/email")
	public ResponseEntity<Student> findStudentByEmail(@RequestBody StudentDTO student) {
		
		return ResponseEntity.ok().body(studentService.findByEmail(student.getEmail()));
	}
	
	
	
	@GetMapping("/create")
	public String createStudent(Model model) {

		model.addAttribute("student", new Student());
		return "student-create-form";
	}

}
