package com.example.jpa.service;

import com.example.jpa.entity.Appointment;
import com.example.jpa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Spring-কে বলি, “এই ক্লাসটা কাজের লোক (সার্ভিস) — মনে রাখো।”
public class AppointmentService {

    @Autowired// Spring-কে বলি, “আমার দরকারি জিনিসটা এনে দাও (যেমন ডেটাবেজের রেপো)।”
    private AppointmentRepository AppointmentRepository;

    /**
     * সমস্ত Appointment তালিকা রিটার্ন করে।
     *
     * @return সকল Appointment এর তালিকা (List<Appointment>)
     */
    public List<Appointment> getAllPatients() {
        return AppointmentRepository.findAll();
    }

    /**
     * নতুন Appointment সংরক্ষণ করে বা বিদ্যমান Appointment আপডেট করে।
     *
     * @param Appointment Appointment অবজেক্ট যেটি সংরক্ষণ করতে হবে
     * @return সংরক্ষিত Appointment অবজেক্ট
     */
    public Appointment saveAppointment(Appointment Appointment) {
        return AppointmentRepository.save(Appointment);
    }

    /**
     * নির্দিষ্ট আইডির Appointment খুঁজে আনে।
     *
     * @param id যেই Appointmentর তথ্য খুঁজে আনতে হবে
     * @return পাওয়া গেলে Appointment অবজেক্ট, না পাওয়া গেলে null
     */
    public Appointment getById(long id){
        return AppointmentRepository.findById(id).orElse(null);
    }

    /**
     * নির্দিষ্ট আইডির Appointment রেকর্ড মুছে ফেলে।
     *
     * @param id যেই Appointment তথ্য মুছে ফেলতে হবে
     */
    public void deleteAppointment(long id){
        AppointmentRepository.deleteById(id);
    }

}
