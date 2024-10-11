package com.med.medicamentapi.service;

import com.med.medicamentapi.model.DoctorModel;
import com.med.medicamentapi.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService extends UniversalServiceImpl<DoctorModel, UUID>{
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        super(doctorRepository);
        this.doctorRepository = doctorRepository;
    }


//    public List<DoctorModel> searchUnit(String value) {
//        return doctorRepository.findByName(value);
//    }
}
