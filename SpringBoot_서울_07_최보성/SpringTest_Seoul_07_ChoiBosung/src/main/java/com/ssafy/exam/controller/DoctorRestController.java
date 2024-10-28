package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;


@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
	
	@Autowired
	DoctorService ds;
	
	@PostMapping
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		if (ds.addDoctor(doctor)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Doctor added successfully");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add doctor");
	}
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> list = ds.getAllDoctors();
		if (list.size() != 0) {
			return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);			
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int id) {
		Doctor doctor = ds.getDoctorById(id);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateDoctor() {
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") int id) {
		if (ds.deleteDoctor(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Doctor deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete doctor");
	}
}
