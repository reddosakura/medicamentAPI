package com.med.medicamentapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "appointment")
public class AppointmentModel {
    @Id
    @GeneratedValue
    private UUID id;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private PatientModel patient;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private DoctorModel doctor;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabinet_id")
    private CabinetModel cabinet;

    @FutureOrPresent
    @Column(name = "appoint_date")
    private Date date;

    public AppointmentModel() {
    }

    public AppointmentModel(UUID id, PatientModel patient, DoctorModel doctor, CabinetModel cabinet, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.cabinet = cabinet;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public CabinetModel getCabinet() {
        return cabinet;
    }

    public void setCabinet(CabinetModel cabinet) {
        this.cabinet = cabinet;
    }

    public @FutureOrPresent Date getDate() {
        return date;
    }

    public void setDate(@FutureOrPresent Date date) {
        this.date = date;
    }
}
