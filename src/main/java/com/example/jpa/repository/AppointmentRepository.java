package com.example.jpa.repository;

import com.example.jpa.entity.Appointment;
import com.example.jpa.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Spring-কে জানায়, "এইটা ডেটাবেজের কাজ করে। খেয়াল রেখো।"
//"এই ক্লাস/ইন্টারফেসটা ডেটাবেজের সাথে যোগাযোগ রাখে। তুমি একে ম্যানেজ করো।"

public interface AppointmentRepository extends JpaRepository<Appointment, Long>  {

//    📌 extends JpaRepository<Patient, Long> — পুরনো কাজ শেখা লোক

//➡️ আমরা বলি:
//            "এই রেকর্ড কিপারকে আগেই শেখানো আছে কিভাবে ডেটা খুঁজতে, যোগ করতে, মুছতে হয়।
//            তাই নতুন করে কিছু শেখাতে হচ্ছে না।"
//
//    এখানে Patient হলো আপনি কোন রকমের তথ্য রাখতে চান (রোগী),
//    আর Long হলো আইডির ধরণ (যেমন: 1, 2, 3... আইডি নম্বর)।

}
