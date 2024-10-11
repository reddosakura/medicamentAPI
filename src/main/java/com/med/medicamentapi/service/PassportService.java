package com.med.medicamentapi.service;

import com.med.medicamentapi.model.PassportModel;
import com.med.medicamentapi.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PassportService extends UniversalServiceImpl<PassportModel, UUID>{
    private final PassportRepository passportRepository;

    @Autowired
    public PassportService(PassportRepository passportRepository) {
        super(passportRepository);
        this.passportRepository = passportRepository;
    }


//    public List<PassportModel> searchUnit(String value) {
//        return passportRepository.findByName(value);
//    }
}
