package com.med.medicamentapi.controllers;

import com.med.medicamentapi.model.AttachmentModel;
import com.med.medicamentapi.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("attachments")
public class AttachController {

    private final AttachmentService attachmentsService;

    @Autowired
    public AttachController(AttachmentService attachmentsRepository){
        this.attachmentsService = attachmentsRepository;
    }

//    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR', 'USER')")
    @GetMapping("/all")
    public List<AttachmentModel> getAllAttachments() {
        return attachmentsService.findAllUnits();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @PostMapping
    public AttachmentModel addAttachment(@RequestBody AttachmentModel attachments) {
        return attachmentsService.addUnit(attachments);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @PutMapping("/update")
    public AttachmentModel updateAttachment(@RequestBody AttachmentModel attachments,
                             @RequestParam UUID id) {
        attachments.setId(id);
        return attachmentsService.updateUnit(attachments, id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @DeleteMapping("/delete")
    public void deleteAttachment(@RequestParam UUID id) {
        attachmentsService.deleteUnit(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @GetMapping("/all/{id}")
    public AttachmentModel getIdAttachment(@PathVariable("id") UUID id) {
        return attachmentsService.findsUnitById(id);
    }
}
