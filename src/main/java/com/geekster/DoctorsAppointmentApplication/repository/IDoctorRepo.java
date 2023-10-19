package com.geekster.DoctorsAppointmentApplication.repository;


import com.geekster.DoctorsAppointmentApplication.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor, Long> {


    Doctor findByDoctorId(Long docId);
}
