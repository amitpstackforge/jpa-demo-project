package com.example.jpa.service;

import com.example.jpa.entity.Appointment;
import com.example.jpa.repository.AppointmentRepository;
import com.example.jpa.repository.DoctorRepository;
import com.example.jpa.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j // Lombok দিয়ে log করার জন্য
@Service //Spring-কে বলি, “এই ক্লাসটা কাজের লোক (সার্ভিস) — মনে রাখো।”
public class AppointmentService {

    @Autowired// Spring-কে বলি, “আমার দরকারি জিনিসটা এনে দাও (যেমন ডেটাবেজের রেপো)।”
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    /**
     * সমস্ত Appointment তালিকা রিটার্ন করে।
     *
     * @return সকল Appointment এর তালিকা (List<Appointment>)
     */
    public List<Appointment> getAllPatients() {
        return appointmentRepository.findAll();
    }

    /**
     * নতুন Appointment সংরক্ষণ করে বা বিদ্যমান Appointment আপডেট করে।
     *
     * @param appointment Appointment অবজেক্ট যেটি সংরক্ষণ করতে হবে
     * @return সংরক্ষিত Appointment অবজেক্ট
     */
    public Appointment saveAppointment(Appointment appointment) {
        Long doctorId = appointment.getDoctor().getId();
        Long patientId = appointment.getPatient().getId();

        // Doctor check
        boolean doctorExists = doctorRepository.existsById(doctorId);
        if (!doctorExists) {
//            log.error("Doctor not found with ID: {}", doctorId);
            throw new IllegalArgumentException("Doctor not found with ID: " + doctorId);
        }

        // Patient check
        boolean patientExists = patientRepository.existsById(patientId);
        if (!patientExists) {
//            log.error("Patient not found with ID: {}", patientId);
            throw new IllegalArgumentException("Patient not found with ID: " + patientId);
        }

//        log.info("Saving appointment for Doctor ID: {} and Patient ID: {}", doctorId, patientId);

        return appointmentRepository.save(appointment);
    }

    /**
     * নির্দিষ্ট আইডির Appointment খুঁজে আনে।
     *
     * @param id যেই Appointmentর তথ্য খুঁজে আনতে হবে
     * @return পাওয়া গেলে Appointment অবজেক্ট, না পাওয়া গেলে null
     */
    public Appointment getById(long id){
        return appointmentRepository.findById(id).orElse(null);
    }

    /**
     * নির্দিষ্ট আইডির Appointment রেকর্ড মুছে ফেলে।
     *
     * @param id যেই Appointment তথ্য মুছে ফেলতে হবে
     */
    public void deleteAppointment(long id){
        appointmentRepository.deleteById(id);
    }

}
