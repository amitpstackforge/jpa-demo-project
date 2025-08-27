package com.example.jpa.controller;

import com.example.jpa.entity.Doctor;
import com.example.jpa.entity.Doctor;
import com.example.jpa.service.DoctorService;
import com.example.jpa.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 📌 এই ক্লাসটি একটি REST API কন্ট্রোলার — এখানে HTTP অনুরোধ (GET, POST, DELETE) আসবে
@RestController
@RequestMapping("/Doctor") // 👉 এই কন্ট্রোলারের সব রিকোয়েস্ট শুরু হবে /Doctor দিয়ে
public class DoctorController {

    // ✅ Spring নিজে থেকেই এই সার্ভিস অবজেক্টটি এনে দেবে
    @Autowired
    private DoctorService doctorService;

    // ✅ সব Doctor তালিকা দেখাবে (GET /Doctor)
    @GetMapping("/all")  // স্পেসিফিক URL পাথ যোগ করা হয়েছে
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors(); // 👉 সার্ভিস থেকে সবDoctorী আনা হচ্ছে
    }

    // ✅ নতুন রোগী যুক্ত করবে (POST /patients)
    @PostMapping("/create")  // স্পেসিফিক URL পাথ
    public Doctor createDoctor(@RequestBody Doctor Doctor) {
        // 📌 @RequestBody মানে: রিকোয়েস্টে যে JSON ডেটা এসেছে, সেটাকে Doctor অবজেক্টে রূপান্তর করা হবে
        return doctorService.saveDoctor(Doctor);
    }

    // ✅ নির্দিষ্ট একজন রোগীর তথ্য দেখাবে (GET /patients/{id})
    @GetMapping("/view/{id}")  // স্পেসিফিক URL পাথ
    public Doctor getDoctor(@PathVariable Long id) {
        // 📌 @PathVariable মানে: URL থেকে id প্যারামিটারটি নিয়ে কাজ করা হচ্ছে
        return doctorService.getById(id);
    }

    // ✅ নির্দিষ্ট একজন রোগীর তথ্য মুছে ফেলবে (DELETE /patients/{id})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        Doctor Doctor = doctorService.getById(id);
        if (Doctor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found with ID " + id);
        }
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor with ID " + id + " deleted successfully.");
    }


}
