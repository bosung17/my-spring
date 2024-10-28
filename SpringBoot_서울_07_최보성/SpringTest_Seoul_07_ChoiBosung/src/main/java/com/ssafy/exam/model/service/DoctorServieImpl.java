package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

@Service
public class DoctorServieImpl implements DoctorService {

	@Autowired
	DoctorDao dd;
	
	@Override
	public boolean addDoctor(Doctor doctor) {
		if (dd.insertDoctor(doctor) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return dd.selectAllDoctors();
	}

	@Override
	public Doctor getDoctorById(int id) {
		return dd.selectDoctorById(id);
	}

	@Override
	public boolean updateDoctor(int id, Doctor doctor) {
		if (dd.updateDoctor(doctor) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDoctor(int id) {
		if (dd.deleteDoctor(id) > 0) {
			return true;
		}
		return false;
	}

}
