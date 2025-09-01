package com.example.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class AppointmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;  // কোন দিনে slot আছে
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean booked = false; // slot খালি আছে কিনা

    @ManyToOne
    @JoinColumn(name = "doctor_availability_id")
    private DoctorAvailability doctorAvailability;

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public DoctorAvailability getDoctorAvailability() {
        return doctorAvailability;
    }

    public void setDoctorAvailability(DoctorAvailability doctorAvailability) {
        this.doctorAvailability = doctorAvailability;
    }
}
