package com.rednails.backendapi.repository;

import com.rednails.backendapi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRopo extends JpaRepository<Appointment, Long> {
}
