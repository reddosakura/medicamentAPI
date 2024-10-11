package com.med.medicamentapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class PatientModel {

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

    @Column(name = "bith_date")
    private Date bith_date;

    @NotBlank
    @NotEmpty
    @Column(name = "citizenship", nullable = false)
    private String citizenship;

    @NotBlank
    @NotEmpty
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "snils", nullable = false)
    private int snils;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private PassportModel passport;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_account_id")
    private UserModel user_account;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attach_id")
    private AttachmentModel attachment;

//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AppointmentModel> appoints;


    public PatientModel() {
    }

    public PatientModel(UUID id, String lastname, String name, String patronymic, String phone_number, String emaildoc, Date bith_date, String citizenship, String gender, Integer height, Integer weight, int snils, PassportModel passport, UserModel user_account, AttachmentModel attachment, List<AppointmentModel> appoints) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
        this.emaildoc = emaildoc;
        this.bith_date = bith_date;
        this.citizenship = citizenship;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.snils = snils;
        this.passport = passport;
        this.user_account = user_account;
        this.attachment = attachment;
        this.appoints = appoints;
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

    public Date getBith_date() {
        return bith_date;
    }

    public void setBith_date(Date bith_date) {
        this.bith_date = bith_date;
    }

    public @NotBlank @NotEmpty String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(@NotBlank @NotEmpty String citizenship) {
        this.citizenship = citizenship;
    }

    public @NotBlank @NotEmpty String getGender() {
        return gender;
    }

    public void setGender(@NotBlank @NotEmpty String gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int getSnils() {
        return snils;
    }

    public void setSnils(int snils) {
        this.snils = snils;
    }

    public PassportModel getPassport() {
        return passport;
    }

    public void setPassport(PassportModel passport) {
        this.passport = passport;
    }

    public UserModel getUser_account() {
        return user_account;
    }

    public void setUser_account(UserModel user_account) {
        this.user_account = user_account;
    }

    public AttachmentModel getAttachment() {
        return attachment;
    }

    public void setAttachment(AttachmentModel attachment) {
        this.attachment = attachment;
    }

    public List<AppointmentModel> getAppoints() {
        return appoints;
    }

    public void setAppoints(List<AppointmentModel> appoints) {
        this.appoints = appoints;
    }
}
