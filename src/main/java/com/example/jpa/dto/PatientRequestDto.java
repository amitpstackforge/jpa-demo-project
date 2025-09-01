package com.example.jpa.dto;

import com.example.jpa.validation.AllowedGender;
import com.example.jpa.validation.NotBlankTrimmed;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PatientRequestDto {

    @NotNull(message = "Name is required")
    @NotBlankTrimmed
    @Size(min = 2, max = 120, message = "Name must be 2-120 chars")
    private String name;

    @NotNull(message = "Birthdate is required")
    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;

    @AllowedGender // MALE / FEMALE / OTHER
    private String gender;

    @NotNull(message = "Email is required")
    @NotBlankTrimmed
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Email is invalid"
    )
    private String email;

    // getters/setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
