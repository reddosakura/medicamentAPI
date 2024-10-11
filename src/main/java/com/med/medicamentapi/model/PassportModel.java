package com.med.medicamentapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.UUID;


@Entity
@Table(name = "passport")
public class PassportModel {

    @Id
    @GeneratedValue
    private UUID id;

    @Digits(integer=4, fraction=0)
    @Column(nullable = false)
    private int series;

    @Digits(integer=6, fraction=0)
    @Column(nullable = false)
    private int number;

    @OneToOne(optional = false, mappedBy = "passport")
    @JsonIgnore
    private PatientModel patient;

    public PassportModel() {
    }

    public PassportModel(UUID id, int series, int number, PatientModel patient) {
        this.id = id;
        this.series = series;
        this.number = number;
        this.patient = patient;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Digits(integer = 4, fraction = 0)
    public int getSeries() {
        return series;
    }

    public void setSeries(@Digits(integer = 4, fraction = 0) int series) {
        this.series = series;
    }

    @Digits(integer = 6, fraction = 0)
    public int getNumber() {
        return number;
    }

    public void setNumber(@Digits(integer = 6, fraction = 0) int number) {
        this.number = number;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }
}
