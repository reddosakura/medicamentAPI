package com.med.medicamentapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.apache.catalina.User;

import java.util.UUID;

@Entity
@Table(name = "doctors")
public class DoctorModel {
    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @NotEmpty
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotBlank
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    @Column(name = "phone_number")
    private String phone_number;

    @Email
    @Column(name = "emaildoc")
    private String emaildoc;

    @Column(name = "tabelNumber", nullable = false)
    private int tabelNumber;

    @NotBlank
    @NotEmpty
    @Column(name = "speciality", nullable = false)
    private String speciality;


    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id")
    private UserModel account;


    public DoctorModel() {
    }

    public DoctorModel(UUID id, String lastname, String name, String patronymic, String phone_number, String emaildoc, int tabelNumber, String speciality, UserModel account) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
        this.emaildoc = emaildoc;
        this.tabelNumber = tabelNumber;
        this.speciality = speciality;
        this.account = account;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank @NotEmpty String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank @NotEmpty String lastname) {
        this.lastname = lastname;
    }

    public @NotBlank @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotBlank @NotEmpty String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$") String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$") String phone_number) {
        this.phone_number = phone_number;
    }

    public @Email String getEmaildoc() {
        return emaildoc;
    }

    public void setEmaildoc(@Email String emaildoc) {
        this.emaildoc = emaildoc;
    }

    public int getTabelNumber() {
        return tabelNumber;
    }

    public void setTabelNumber(int tabelNumber) {
        this.tabelNumber = tabelNumber;
    }

    public @NotBlank @NotEmpty String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(@NotBlank @NotEmpty String speciality) {
        this.speciality = speciality;
    }

    public UserModel getAccount() {
        return account;
    }

    public void setAccount(UserModel account) {
        this.account = account;
    }
}
