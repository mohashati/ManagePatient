package com.managePatient.services;

import com.managePatient.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by tmoshasha on 2017/08/13.
 */

public class AppointmentServiceTest {
    @Autowired
    AppointmentRepository repository;
/**
    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","12");
        values.put("appointmentDate","2017-08-14");
    }

    @Test
    public void create() throws Exception {
        Appointment appointment = AppointmentFactory.getAppointment(values,"12");
        service.save(appointment);
        assertEquals("2017-08-14",appointment.getAppointmentDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Appointment readAppointment = service.findById("12");
        assertEquals("2017-08-14",readAppointment.getAppointmentDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Appointment readAppointment = service.findById("12");
        Appointment newAppointment = new Appointment.Builder()
                .appointmentDate(values.get("2017-09-09"))
                .build();
        service.update("13");
        Appointment updatedAppointment = service.findById("13");
        assertEquals("2017-09-09", updatedAppointment.getAppointmentDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("12");
        Appointment appointment = service.findById("13");
        assertNull(appointment);
    }
*/
}
