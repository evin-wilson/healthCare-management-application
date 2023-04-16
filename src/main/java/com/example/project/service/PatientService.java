package com.example.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Model.Patient;
import com.example.project.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repo;
	
	public Map<String, String> registerPatient(Patient patient) {
		try {			
			repo.save(patient);
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "Registration sucessful");
			return map;
		}catch(Exception e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "Registration failure");
			return map;
		}
		
	}

	public Map<String, List<Patient>> getAllPatients() {
		List<Patient> patients = repo.findAll();
		Map<String, List<Patient>> map = new HashMap<>();
		map.put("patients", patients);
		return map;
	}

	public Optional<Patient> getPatient(String id) {
		return repo.findById(id);
	}

	public void delPatient(String id) {
		repo.deleteById(id);
	}


}

