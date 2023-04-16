package com.example.project.controller;


import com.example.project.Model.Patient;
import com.example.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping(value = "/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> regPatient(@RequestBody Patient patient) {
        return service.registerPatient(patient);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<Patient> getList() {
        Map<String, List<Patient>> allPatients = service.getAllPatients();
        return allPatients.get("patients");
    }

    @GetMapping(value = "/view/{id}")
    @ResponseBody
    public Optional<Patient> viewById(@PathVariable String id) {
        return service.getPatient(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public void deltPatient(@PathVariable String id) {
        service.delPatient(id);
    }


}
