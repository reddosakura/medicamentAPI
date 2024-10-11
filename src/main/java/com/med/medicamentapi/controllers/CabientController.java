package com.med.medicamentapi.controllers;

import com.med.medicamentapi.model.CabinetModel;
import com.med.medicamentapi.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cabinets")

public class CabientController {

    private final CabinetService cabinetService;

    @Autowired
    public CabientController(CabinetService cabinetRepository){
        this.cabinetService = cabinetRepository;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/all")
    public List<CabinetModel> getAllCabinets() {
        return cabinetService.findAllUnits();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public CabinetModel addCabinet(@RequestBody CabinetModel cabinet) {
        return cabinetService.addUnit(cabinet);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/update")
    public CabinetModel updateCabinet(@RequestBody CabinetModel cabinet,
                             @RequestParam UUID id) {
        cabinet.setId(id);
        return cabinetService.updateUnit(cabinet, id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete")
    public void deleteCabinet(@RequestParam UUID id) {
        cabinetService.deleteUnit(id);
    }

    @GetMapping("/all/{id}")
    public CabinetModel getIdCabinet(@PathVariable("id") UUID id) {
        return cabinetService.findsUnitById(id);
    }
}
