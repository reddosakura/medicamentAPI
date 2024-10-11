package com.med.medicamentapi.controllers;

import com.med.medicamentapi.model.AppointmentModel;
import com.med.medicamentapi.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("appointments")
//@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentRepository){
        this.appointmentService = appointmentRepository;
    }

    @GetMapping("/all")
    public List<AppointmentModel> getAllAppointments() {
        return appointmentService.findAllUnits();
    }

    @PostMapping
    public AppointmentModel addAppointment(@RequestBody AppointmentModel appointment) {
        return appointmentService.addUnit(appointment);
    }

    @PutMapping("/update")
    public AppointmentModel updateAppointment(@RequestBody AppointmentModel appointment,
                             @RequestParam UUID id) {
        appointment.setId(id);
        return appointmentService.updateUnit(appointment, id);
    }

    @DeleteMapping("/delete")
    public void deleteAppointment(@RequestParam UUID id) {
        appointmentService.deleteUnit(id);
    }

    @GetMapping("/all/{id}")
    public List<AppointmentModel> getIdAppointment(@PathVariable("id") UUID id) {
        return appointmentService.searchUnit(id);
    }
}
