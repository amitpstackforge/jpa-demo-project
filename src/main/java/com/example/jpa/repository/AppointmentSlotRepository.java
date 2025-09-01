package com.example.jpa.repository;

import com.example.jpa.entity.Appointment;
import com.example.jpa.entity.AppointmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, Long> {

}
