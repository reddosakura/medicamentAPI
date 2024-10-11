package com.med.medicamentapi.controllers;

import com.med.medicamentapi.model.PatientModel;
import com.med.medicamentapi.model.UserModel;
import com.med.medicamentapi.service.PatientService;
import com.med.medicamentapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("patients")
public class PatientController {

    private final PatientService patientService;
    private final UserService userService;

    @Autowired
    public PatientController(PatientService patientRepository, UserService userService){
        this.patientService = patientRepository;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<PatientModel> getAllPatients() {
        return patientService.findAllUnits();
    }

    @PostMapping
    public PatientModel addPatient(@RequestBody PatientModel patient) {
        return patientService.addUnit(patient);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @PutMapping("/update")
    public PatientModel updatePatient(@RequestBody PatientModel patient,
                             @RequestParam UUID id) {
        patient.setId(id);
        patient.setUser_account(userService.getById(patient.getUser_account().getId()));
        return patientService.updateUnit(patient, id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @DeleteMapping("/delete")
    public void deletePatient(@RequestParam UUID id) {
        patientService.deleteUnit(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @GetMapping("/all/{id}")
    public PatientModel getIdPatient(@PathVariable("id") UUID id) {
        return patientService.findsUnitById(id);
    }

//    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR', 'USER')")
    @GetMapping("/user/{id}")
    public PatientModel getByUserId(@PathVariable("id") UUID id) {
        return patientService.searchUnit(id);
    }
}
