package org.back.src.user.dto;

import org.back.src.user.enums.EUserType;

public class UserRequestDto {
    private String name;
    private String registration;
    private String email;
    private String password;
    private EUserType eUserType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public EUserType geteUserType() { return eUserType; }

    public void seteUserType(EUserType eUserType) { this.eUserType = eUserType; }
}