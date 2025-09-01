package com.example.jpa.service;

import com.example.jpa.dto.DoctorAvailabilityRequestDto;
import com.example.jpa.entity.Doctor;
import com.example.jpa.entity.DoctorAvailability;
import com.example.jpa.exception.InvalidAvailabilityException;
import com.example.jpa.repository.DoctorAvailabilityRepository;
import com.example.jpa.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class DoctorAvailabilityService {


    @Autowired
    private DoctorAvailabilityRepository  doctorAvailabilityRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // Service method: ডাক্তার এর availability (কোন দিনে, কত সময় available থাকবেন) সেট করার জন্য
    public DoctorAvailability setAvailability(Long doctorId, DoctorAvailabilityRequestDto dto) {

        // 1. Doctor কে database থেকে খুঁজে আনা doctorId দিয়ে
        // যদি না পাওয়া যায় তাহলে custom exception throw করবে
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new InvalidAvailabilityException("Doctor not found with ID " + doctorId));

        // 2. DTO থেকে আসা dayOfWeek (যেমন MONDAY, TUESDAY) কে Enum এ রূপান্তর করা
        DayOfWeek dayOfWeek;
        try {
            // toUpperCase() করা হয়েছে যাতে user "monday", "MONDAY", "Monday" যেভাবেই লিখুক, কাজ করে
            dayOfWeek = DayOfWeek.valueOf(dto.getDayOfWeek().toUpperCase());
        } catch (IllegalArgumentException e) {
            // যদি ভুল দিন দেওয়া হয় (যেমন Somobaar 😅), তাহলে custom exception throw হবে
            throw new InvalidAvailabilityException("Invalid day of week: " + dto.getDayOfWeek());
        }

        // 3. DTO থেকে আসা সময় (AM/PM format) কে LocalTime এ parse করা
        // "hh:mm a" মানে ১২ ঘন্টার format, সাথে AM/PM (যেমন "10:00 AM")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);

        // Start time কে LocalTime এ convert করা
        LocalTime start = LocalTime.parse(dto.getStartTime().toUpperCase(), formatter);

        // End time কে LocalTime এ convert করা
        LocalTime end = LocalTime.parse(dto.getEndTime().toUpperCase(), formatter);

        // 4. Validation: End time অবশ্যই Start time এর পর হতে হবে
        if (end.isBefore(start)) {
            throw new InvalidAvailabilityException("End time must be after start time");
        }

        // 5. Validation: Slot duration positive হতে হবে (0 বা negative হলে invalid)
        if (dto.getSlotDuration() <= 0) {
            throw new InvalidAvailabilityException("Slot duration must be greater than 0");
        }
        LocalTime lunchStart = dto.getLunchStart() != null
                ? LocalTime.parse(dto.getLunchStart().toUpperCase(), formatter)
                : null;

        LocalTime lunchEnd = dto.getLunchEnd() != null
                ? LocalTime.parse(dto.getLunchEnd().toUpperCase(), formatter)
                : null;


        // 6. নতুন DoctorAvailability object তৈরি করা
        DoctorAvailability availability = new DoctorAvailability();

        // কোন Doctor এর জন্য এই availability, সেটা সেট করা হলো
        availability.setDoctor(doctor);

        // কোন দিন available → MONDAY/TUESDAY ইত্যাদি সেট করা
        availability.setDayOfWeek(dayOfWeek);

        // শুরু সময় সেট করা
        availability.setStartTime(start);

        // শেষ সময় সেট করা
        availability.setEndTime(end);

        // প্রতিটি appointment slot কত মিনিটের হবে সেট করা
        availability.setSlotDuration(dto.getSlotDuration());

        availability.setLunchStart(lunchStart);
        availability.setLunchEnd(lunchEnd);

        // 7. Database এ save করা এবং return করা
        return doctorAvailabilityRepository.save(availability);
    }



}
