package com.med.medicamentapi.service;

import com.med.medicamentapi.model.AppointmentModel;
import com.med.medicamentapi.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService extends UniversalServiceImpl<AppointmentModel, UUID>{
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        super(appointmentRepository);
        this.appointmentRepository = appointmentRepository;
    }


    public List<AppointmentModel> searchUnit(UUID value) {
        return appointmentRepository.findByPatientId(value);
    }
}
