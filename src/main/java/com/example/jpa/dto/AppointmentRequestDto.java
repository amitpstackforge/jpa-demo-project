package com.example.jpa.dto;

import com.example.jpa.validation.NotBlankTrimmed;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AppointmentRequestDto {

    @NotNull(message = "Appointment date is required")
    @FutureOrPresent(message = "Appointment date cannot be in the past")
    private LocalDate appointmentDate;

    @NotNull(message = "Reason is required")
    @NotBlankTrimmed
    @Size(min = 3, max = 255, message = "Reason must be 3-255 chars")
    // কমপক্ষে ১টা visible character (সব স্পেস নয়), basic content rule
    @Pattern(regexp = ".*\\S.*", message = "Reason cannot be only whitespace")
    private String reason;

    @NotNull(message = "doctorId is required")
    private Long doctorId;

    @NotNull(message = "patientId is required")
    private Long patientId;

    // getters/setters

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
