package com.managePatient.repositories;

import java.util.Map;

/**
 * Created by tmoshasha on 2017/08/13.
 */
public class AppointmentRepositoryTest {
    Map<String,String> values;
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
        repository.save(appointment);
        assertEquals("2017-08-14",appointment.getAppointmentDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Appointment readAppointment = repository.findOne("12");
        assertEquals("2017-08-14",readAppointment.getAppointmentDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Appointment readAppointment = repository.findOne("12");
        Appointment newAppointment = new Appointment.Builder()
                .appointmentDate(values.get("2017-09-09"))
                .build();
        repository.findOne("12");
        Appointment updatedAppointment = repository.findOne("12");
        assertEquals("2017-09-09", updatedAppointment.getAppointmentDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("12");
        Appointment appointment = repository.findOne("12");
        assertNull(appointment);
    }
*/
}
