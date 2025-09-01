package com.example.jpa.dto;

import com.example.jpa.validation.NotBlankTrimmed;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoctorRequestDto {

    @NotNull(message = "Name is required")
    @NotBlankTrimmed
    @Size(min = 2, max = 100, message = "Name must be 2-100 chars")
    // শুধুই অক্ষর, স্পেস, ডট, হাইফেন
    @Pattern(regexp = "^[A-Za-z .\\-]+$", message = "Name may contain letters, spaces, dot and hyphen")
    private String name;

    @NotNull(message = "Specialization is required")
    @NotBlankTrimmed
    @Size(min = 2, max = 80, message = "Specialization must be 2-80 chars")
    private String specialization;

    @NotNull(message = "Email is required")
    @NotBlankTrimmed
    // @Email-ও ব্যবহার করতে পারেন; অনুরোধ মত @Pattern দেখানো হলো
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
