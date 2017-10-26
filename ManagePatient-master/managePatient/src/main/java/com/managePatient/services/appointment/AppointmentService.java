package com.managePatient.services.appointment;

import com.managePatient.domain.Appointment;
import com.managePatient.services.BasicCrudService;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by tmoshasha on 2017/08/13.
 */

@Service
public interface AppointmentService extends BasicCrudService<Appointment,String>{}
