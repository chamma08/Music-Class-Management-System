package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TeacherController {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	//get all teachers
	@GetMapping("/teachers")
	public List<Teacher> getAllTeachers(){
		return teacherRepository.findAll();
	}
	
	//create teachers rest api
	@PostMapping("/teachers")
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	//get Teachers by Id
	@GetMapping("/teachers/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
		Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id:" + id));
		return ResponseEntity.ok(teacher);
	}
	
	//update Teacher
	@PutMapping("/teachers/{id}")
	public ResponseEntity<Teacher> updateEmployee(@PathVariable Long id, @RequestBody Teacher teacherDetails){
		Teacher teacher = teacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id :" + id));
		
		teacher.setFirstName(teacherDetails.getFirstName());
		teacher.setLastName(teacherDetails.getLastName());
		teacher.setEmailId(teacherDetails.getEmailId());
		teacher.setSubject(teacherDetails.getSubject());
		
		Teacher updatedTeacher = teacherRepository.save(teacher);
		return ResponseEntity.ok(updatedTeacher);
	}
	
	//delete Teacher
	@DeleteMapping("/teachers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTeacher(@PathVariable Long id){
		Teacher teacher = teacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id :" + id));
		teacherRepository.delete(teacher);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
