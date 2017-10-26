package com.managePatient.repositories;

import com.managePatient.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tmoshasha on 2017/08/13.
 */

public interface AppointmentRepository extends CrudRepository<Appointment, String> {}
