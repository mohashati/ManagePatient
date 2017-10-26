package com.managePatient.factories;


import com.managePatient.domain.Appointment;

/**
 * Created by tmoshasha on 2017/08/11.
 */
public class AppointmentFactory {
    public static Appointment buildAppointment(String date){
        Appointment appointment = new Appointment.Builder()
                .appointmentDate(date)
                .build();
        return appointment;
    }
}
