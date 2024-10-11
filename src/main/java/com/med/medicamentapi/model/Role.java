package com.med.medicamentapi.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, DOCTOR;


    @Override
    public String getAuthority() {
        return name();
    }
}