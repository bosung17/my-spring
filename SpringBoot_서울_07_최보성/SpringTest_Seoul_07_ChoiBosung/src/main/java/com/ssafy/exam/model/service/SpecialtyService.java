package com.ssafy.exam.model.service;

import org.springframework.context.annotation.Configuration;

import com.ssafy.exam.model.dto.Specialty;

public interface SpecialtyService {
	boolean addSpecialty(Specialty specialty);

	Specialty getSpecialtyByCode(int code);

	boolean deleteSpecialty(int code);
}