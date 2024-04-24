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
import com.example.demo.model.Student;
import com.example.demo.model.classDetails;
import com.example.demo.repository.classDetailRepository;

import jakarta.persistence.Id;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class ClassDetailsController {

	@Autowired
	private classDetailRepository ClassDetailRepository;
	
	//get all details
	@GetMapping("/details")
	public List<classDetails> getAllDetails(){
		return ClassDetailRepository.findAll();
	}
	
	//create class details rest api
	@PostMapping("/details")
	public classDetails createDetail(@RequestBody classDetails cd) {
		return ClassDetailRepository.save(cd);
	}
	
	//get class by id
	@GetMapping("/details/{id}")
	public ResponseEntity<classDetails> getClassById(@PathVariable Long id) {
		classDetails detail = ClassDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class detail not exist with id:" + id));
		return ResponseEntity.ok(detail);
	}
	
	//update 
	@PutMapping("/details/{id}")
	public ResponseEntity<classDetails> updateDetail(@PathVariable Long id, @RequestBody classDetails ClassDetails){
		classDetails detail = ClassDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		detail.setClassName(ClassDetails.getClassName());
		detail.setTeacherName(ClassDetails.getTeacherName());
		detail.setDescription(ClassDetails.getDescription());
		detail.setTime(ClassDetails.getTime());
		
		classDetails updateDetail = ClassDetailRepository.save(detail);
		return ResponseEntity.ok(updateDetail);
	}
	
	//delete Details
	@DeleteMapping("/details/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDetails(@PathVariable Long id){
		classDetails detail = ClassDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Detail not exist with id :" + id));
		ClassDetailRepository.delete(detail);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
