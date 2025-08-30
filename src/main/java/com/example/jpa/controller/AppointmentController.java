package com.example.jpa.controller;

import com.example.jpa.entity.Appointment;
import com.example.jpa.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AppointmentController:
 * এই কন্ট্রোলার মূলত HTTP রিকোয়েস্ট (API কল) রিসিভ করে সার্ভিস লেয়ারে পাঠায়
 * আর সার্ভিস লেয়ার থেকে পাওয়া ডেটা রিটার্ন করে।
 */
@RestController // বলি → "এই ক্লাসটা REST API endpoint হিসেবে কাজ করবে"
@RequestMapping("/appointments") // সব URL /appointments দিয়ে শুরু হবে
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    /**
     * সব Appointment লিস্ট আনার জন্য GET API
     * উদাহরণ: GET http://localhost:8080/appointments
     */
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllPatients();
    }

    /**
     * নতুন Appointment তৈরি বা বিদ্যমান Appointment আপডেট করার জন্য POST API
     * উদাহরণ: POST http://localhost:8080/appointments
     * Request Body: { "appointmentDate": "2025-08-30", "reason": "Checkup", "doctor": {...}, "patient": {...} }
     */
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    /**
     * নির্দিষ্ট Appointment আইডি দিয়ে খোঁজার জন্য GET API
     * উদাহরণ: GET http://localhost:8080/appointments/1
     */
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable long id) {
        return appointmentService.getById(id);
    }

    /**
     * Appointment আপডেট করার জন্য PUT API
     * উদাহরণ: PUT http://localhost:8080/appointments/1
     * Request Body: { "appointmentDate": "2025-09-01", "reason": "Follow-up" }
     */
    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) {
        appointment.setId(id); // নির্দিষ্ট আইডির ডেটা আপডেট হবে
        return appointmentService.saveAppointment(appointment);
    }

    /**
     * Appointment ডিলিট করার জন্য DELETE API
     * উদাহরণ: DELETE http://localhost:8080/appointments/1
     */
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
    }
}
