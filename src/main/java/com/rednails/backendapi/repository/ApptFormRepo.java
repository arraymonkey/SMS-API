package com.rednails.backendapi.repository;

import com.rednails.backendapi.model.AppointmentForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApptFormRepo extends JpaRepository<AppointmentForm, Long> {
}
