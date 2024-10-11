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
@Table(name = "cabinet")
public class CabinetModel {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @NotEmpty
    private String name;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    @OneToMany(mappedBy = "cabinet", cascade = CascadeType.ALL)
    private List<AppointmentModel> appoints;

    public CabinetModel() {
    }

    public CabinetModel(UUID id, String name, List<AppointmentModel> appoints) {
        this.id = id;
        this.name = name;
        this.appoints = appoints;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotBlank @NotEmpty String name) {
        this.name = name;
    }

    public List<AppointmentModel> getAppoints() {
        return appoints;
    }

    public void setAppoints(List<AppointmentModel> appoints) {
        this.appoints = appoints;
    }
}
