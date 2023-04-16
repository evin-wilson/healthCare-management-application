package com.example.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;
import com.example.project.repository.AppointmentRepository;
import com.example.project.repository.PatientRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repo;

	public Map<String, String> registerAppointment(Appointment appointment) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			repo.save(appointment);
			map.put("message", "Booking sucessful");
		}catch (Exception e) {
			map.put("message", "Booking failure");
		}
		return map;
	}

	public List<Appointment> getAllAppointments() {
		return repo.findAll();
	}

	public Appointment getAllAppointementOfAPerson(String id) {
		return null;
	}

	public Optional<Appointment> getPatientById(String id) {
		return repo.findById(id);
	}

	public void deleteAppointment(String id) {
		repo.deleteById(id);	
	}
}
