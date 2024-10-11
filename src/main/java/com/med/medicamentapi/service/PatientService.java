package com.med.medicamentapi.service;

import com.med.medicamentapi.model.PatientModel;
import com.med.medicamentapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService extends UniversalServiceImpl<PatientModel, UUID>{
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        super(patientRepository);
        this.patientRepository = patientRepository;
    }


    public PatientModel searchUnit(UUID value) {
        return patientRepository.findPatientByUserAccountId(value);
    }
}
