package com.med.medicamentapi.controllers;

import com.med.medicamentapi.model.DoctorModel;
import com.med.medicamentapi.service.DoctorService;
import com.med.medicamentapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final UserService userService;

    @Autowired
    public DoctorController(DoctorService doctorRepository, UserService userService){
        this.doctorService = doctorRepository;
        this.userService = userService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR', 'USER')")
    @GetMapping("/all")
    public List<DoctorModel> getAllDoctors() {
        return doctorService.findAllUnits();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @PostMapping
    public DoctorModel addDoctor(@RequestBody DoctorModel doctor) {
        return doctorService.addUnit(doctor);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @PutMapping("/update")
    public DoctorModel updateDoctor(@RequestBody DoctorModel doctor,
                             @RequestParam UUID id) {
        doctor.setId(id);
        doctor.setAccount(userService.getById(doctor.getAccount().getId()));
//        patient.setuseraccount(userService.getById(patient.getuseraccount().getId()));
        return doctorService.updateUnit(doctor, id);
    }

    @DeleteMapping("/delete")
    public void deleteDoctor(@RequestParam UUID id) {
        doctorService.deleteUnit(id);
    }

    @GetMapping("/all/{id}")
    public DoctorModel getIdDoctor(@PathVariable("id") UUID id) {
        return doctorService.findsUnitById(id);
    }
}
