package com.med.medicamentapi.controllers;

import com.med.medicamentapi.model.PassportModel;
import com.med.medicamentapi.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("passports")
@PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
public class PassportController {

    private final PassportService passportService;

    @Autowired
    public PassportController(PassportService passportRepository){
        this.passportService = passportRepository;
    }

    @GetMapping("/all")
    public List<PassportModel> getAllPassports() {
        return passportService.findAllUnits();
    }

    @PostMapping
    public PassportModel addPassport(@RequestBody PassportModel passport) {
        return passportService.addUnit(passport);
    }

    @PutMapping("/update")
    public PassportModel updatePassport(@RequestBody PassportModel passport,
                             @RequestParam UUID id) {
        passport.setId(id);
        return passportService.updateUnit(passport, id);
    }

    @DeleteMapping("/delete")
    public void deletePassport(@RequestParam UUID id) {
        passportService.deleteUnit(id);
    }

    @GetMapping("/all/{id}")
    public PassportModel getIdPassport(@PathVariable("id") UUID id) {
        return passportService.findsUnitById(id);
    }
}
