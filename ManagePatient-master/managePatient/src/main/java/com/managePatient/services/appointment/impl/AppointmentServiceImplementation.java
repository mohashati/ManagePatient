package com.managePatient.services.appointment.impl;

import com.managePatient.domain.Appointment;
import com.managePatient.repositories.AppointmentRepository;
import com.managePatient.services.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tmoshasha on 2017/08/13.
 */
@Service

public class AppointmentServiceImplementation  implements AppointmentService {

    @Autowired
    private  AppointmentRepository appointmentRepository;

    @Override
    public Appointment save(Appointment appointment) {return  appointmentRepository.save(appointment);}

    @Override
    public Appointment findById(String id) {return appointmentRepository.findOne(id);}

    @Override
    public Appointment update(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Appointment entity) {
        appointmentRepository.delete(entity);
    }

    @Override
    public Iterable<Appointment> readAll() {
        Iterable<Appointment> result = appointmentRepository.findAll();
        return result;
    }
}
