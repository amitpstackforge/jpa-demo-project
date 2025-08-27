package com.example.jpa.controller;

import com.example.jpa.entity.Patient;
import com.example.jpa.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 📌 এই ক্লাসটি একটি REST API কন্ট্রোলার — এখানে HTTP অনুরোধ (GET, POST, DELETE) আসবে
@RestController
@RequestMapping("/patients") // 👉 এই কন্ট্রোলারের সব রিকোয়েস্ট শুরু হবে /patients দিয়ে
public class PatientController {

    // ✅ Spring নিজে থেকেই এই সার্ভিস অবজেক্টটি এনে দেবে
    @Autowired
    private PatientService patientService;

    // ✅ সব রোগীর তালিকা দেখাবে (GET /patients)
    @GetMapping("/all")  // স্পেসিফিক URL পাথ যোগ করা হয়েছে
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients(); // 👉 সার্ভিস থেকে সব রোগী আনা হচ্ছে
    }

    // ✅ নতুন রোগী যুক্ত করবে (POST /patients)
    @PostMapping("/create")  // স্পেসিফিক URL পাথ
    public Patient createPatient(@RequestBody Patient patient) {
        // 📌 @RequestBody মানে: রিকোয়েস্টে যে JSON ডেটা এসেছে, সেটাকে Patient অবজেক্টে রূপান্তর করা হবে
        return patientService.savePatient(patient);
    }

    // ✅ নির্দিষ্ট একজন রোগীর তথ্য দেখাবে (GET /patients/{id})
    @GetMapping("/view/{id}")  // স্পেসিফিক URL পাথ
    public Patient getPatient(@PathVariable Long id) {
        // 📌 @PathVariable মানে: URL থেকে id প্যারামিটারটি নিয়ে কাজ করা হচ্ছে
        return patientService.getPatientById(id);
    }

    // ✅ নির্দিষ্ট একজন রোগীর তথ্য মুছে ফেলবে (DELETE /patients/{id})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with ID " + id);
        }
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient with ID " + id + " deleted successfully.");
    }


}
