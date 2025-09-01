package com.example.jpa.service;

import com.example.jpa.entity.Doctor;
import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Spring-কে বলি, “এই ক্লাসটা কাজের লোক (সার্ভিস) — মনে রাখো।”
public class DoctorService {

    @Autowired// Spring-কে বলি, “আমার দরকারি জিনিসটা এনে দাও (যেমন ডেটাবেজের রেপো)।”
    private DoctorRepository doctorRepository;

    /**
     * সমস্ত Doctor তালিকা রিটার্ন করে।
     *
     * @return সকল Doctor এর তালিকা (List<Doctor>)
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * নতুন Doctor সংরক্ষণ করে বা বিদ্যমান Doctor আপডেট করে।
     *
     * @param doctor Doctor অবজেক্ট যেটি সংরক্ষণ করতে হবে
     * @return সংরক্ষিত Doctor অবজেক্ট
     */
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * নির্দিষ্ট আইডির Doctor খুঁজে আনে।
     *
     * @param id যেই Doctorর তথ্য খুঁজে আনতে হবে
     * @return পাওয়া গেলে Doctor অবজেক্ট, না পাওয়া গেলে null
     */


    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));
    }
    /**
     * নির্দিষ্ট আইডির Doctor রেকর্ড মুছে ফেলে।
     *
     * @param id যেই Doctor তথ্য মুছে ফেলতে হবে
     */
    public void deleteDoctor(long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));

        doctorRepository.deleteById(id);
    }
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));

        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setEmail(doctorDetails.getEmail());

        return doctorRepository.save(doctor);
    }
}
