package com.example.project.controller;

import com.example.project.Model.Appointment;
import com.example.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping(value = "/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> regAppointment(@RequestBody Appointment appointment) {
        return service.registerAppointment(appointment);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<Appointment> getList() {
        return service.getAllAppointments();
    }

    @GetMapping(value = "/list/{id}")
    @ResponseBody
    public Appointment getListById(@PathVariable String id) {
        return service.getAllAppointementOfAPerson(id);
    }

    @GetMapping(value = "/view/{id}")
    @ResponseBody
    public Optional<Appointment> viewById(@PathVariable String id) {
        return service.getPatientById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteAppointment(@PathVariable String id) {
        service.deleteAppointment(id);
    }

}
