package com.ssafy.exam.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
	
	@Autowired
	SpecialtyDao sd;

	@Override
	public boolean addSpecialty(Specialty specialty) {
		if (sd.insertSpecialty(specialty) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Specialty getSpecialtyByCode(int code) {
		return sd.selectSpecialtyByCode(code);
	}

	@Override
	public boolean deleteSpecialty(int code) {
		if (sd.deleteSpecialty(code) > 0) {
			return true;
		}
		return false;
	}

}
