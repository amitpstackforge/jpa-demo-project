package com.example.jpa.service;

import com.example.jpa.entity.Patient;
import com.example.jpa.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Spring-কে বলি, “এই ক্লাসটা কাজের লোক (সার্ভিস) — মনে রাখো।”
public class PatientService {

    @Autowired// Spring-কে বলি, “আমার দরকারি জিনিসটা এনে দাও (যেমন ডেটাবেজের রেপো)।”
    private PatientRepository patientRepository;

    /**
     * সমস্ত রোগীর তালিকা রিটার্ন করে।
     *
     * @return সকল Patient এর তালিকা (List<Patient>)
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * নতুন রোগী সংরক্ষণ করে বা বিদ্যমান রোগী আপডেট করে।
     *
     * @param patient Patient অবজেক্ট যেটি সংরক্ষণ করতে হবে
     * @return সংরক্ষিত Patient অবজেক্ট
     */
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     * নির্দিষ্ট আইডির রোগী খুঁজে আনে।
     *
     * @param id যেই রোগীর তথ্য খুঁজে আনতে হবে
     * @return পাওয়া গেলে Patient অবজেক্ট, না পাওয়া গেলে null
     */
    public Patient getPatientById(long id){
        return patientRepository.findById(id).orElse(null);
    }

    /**
     * নির্দিষ্ট আইডির রোগীর রেকর্ড মুছে ফেলে।
     *
     * @param id যেই রোগীর তথ্য মুছে ফেলতে হবে
     */
    public void deletePatient(long id){
        patientRepository.deleteById(id);
    }

}
