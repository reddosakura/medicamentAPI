package com.med.medicamentapi.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "attachments")
public class AttachmentModel {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @NotEmpty
    @Column(name = "type_name", nullable = false)
    private String type_name;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    @OneToMany(mappedBy = "attachment", cascade = CascadeType.ALL)
    private List<PatientModel> patients;

    public AttachmentModel() {
    }

    public AttachmentModel(UUID id, String type_name, List<PatientModel> patients) {
        this.id = id;
        this.type_name = type_name;
        this.patients = patients;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank @NotEmpty String getType_name() {
        return type_name;
    }

    public void setType_name(@NotBlank @NotEmpty String type_name) {
        this.type_name = type_name;
    }

    public List<PatientModel> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientModel> patients) {
        this.patients = patients;
    }
}
