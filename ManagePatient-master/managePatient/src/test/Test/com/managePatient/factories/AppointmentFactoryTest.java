package com.managePatient.factories;


import com.managePatient.domain.Appointment;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tmoshasha on 2017/08/13.
 */
public class AppointmentFactoryTest {

    private static String id = "89898989";
    private static String date = "2017-08-14";

    @BeforeClass
    public static void setUp() throws Exception {
        Appointment values = new Appointment(id,date);
    }
    @Test
    public void getAppointment() throws Exception {
        Appointment appointment = AppointmentFactory.buildAppointment(date);
        assertEquals("2017-08-14",appointment.getAppointmentDate());
        System.out.print(appointment.getId());
        System.out.print(appointment.getAppointmentDate());
    }
}
