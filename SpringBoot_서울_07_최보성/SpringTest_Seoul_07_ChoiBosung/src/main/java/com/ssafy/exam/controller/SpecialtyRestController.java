package com.ssafy.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;


@RestController
@RequestMapping("/api/specialty")
public class SpecialtyRestController {
	
	@Autowired
	SpecialtyService ss;
	
	@PostMapping
    public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
		if (ss.addSpecialty(specialty)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Specialty added successfully");		
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add specialty");
    }
	
	@GetMapping("/{code}")
    public ResponseEntity<Specialty> getSpecialty(@PathVariable("code") int code) {
		Specialty specialty = ss.getSpecialtyByCode(code);
		return new ResponseEntity<Specialty>(specialty, HttpStatus.OK);
    }

	@DeleteMapping("/{code}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable("code") int code) {
		if (ss.deleteSpecialty(code)) {
			return ResponseEntity.status(HttpStatus.OK).body("Specialty deleted successfully");		
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete specialty");
    }
}