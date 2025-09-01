package com.example.jpa.repository;

import com.example.jpa.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Spring-কে জানায়, "এইটা ডেটাবেজের কাজ করে। খেয়াল রেখো।"
//"এই ক্লাস/ইন্টারফেসটা ডেটাবেজের সাথে যোগাযোগ রাখে। তুমি একে ম্যানেজ করো।"

public interface DoctorRepository extends JpaRepository<Doctor, Long>  {

    List<Doctor> findBySpecializationIgnoreCase(String specialization);

}
