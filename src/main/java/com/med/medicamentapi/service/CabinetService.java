package com.med.medicamentapi.service;

import com.med.medicamentapi.model.CabinetModel;
import com.med.medicamentapi.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CabinetService extends UniversalServiceImpl<CabinetModel, UUID>{
    private final CabinetRepository cabinetRepository;

    @Autowired
    public CabinetService(CabinetRepository cabinetRepository) {
        super(cabinetRepository);
        this.cabinetRepository = cabinetRepository;
    }


//    public List<CabinetModel> searchUnit(String value) {
//        return cabinetRepository.findByName(value);
//    }
}
