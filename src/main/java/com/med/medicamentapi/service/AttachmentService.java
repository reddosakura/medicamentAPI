package com.med.medicamentapi.service;

import com.med.medicamentapi.model.AttachmentModel;
import com.med.medicamentapi.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttachmentService extends UniversalServiceImpl<AttachmentModel, UUID>{
    private final AttachmentRepository attachRepository;

    @Autowired
    public AttachmentService(AttachmentRepository attachRepository) {
        super(attachRepository);
        this.attachRepository = attachRepository;
    }


//    public List<AttachmentModel> searchUnit(String value) {
//        return attachRepository.findByName(value);
//    }
}
