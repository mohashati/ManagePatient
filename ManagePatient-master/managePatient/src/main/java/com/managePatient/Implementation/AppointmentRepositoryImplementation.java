package com.managePatient.Implementation;

/**
 * Created by tmoshasha on 2017/08/13.
 */


public class AppointmentRepositoryImplementation{}
/**
public class AppointmentRepositoryImplementation implements AppointmentRepository {

    private static AppointmentRepositoryImplementation repository = null;
    private Map<String, Appointment> appointmentTable;
    private AppointmentRepositoryImplementation(){appointmentTable = new HashMap<String, Appointment>();}

    public static AppointmentRepositoryImplementation getInstance(){
        if(repository ==null)
            repository = new AppointmentRepositoryImplementation();
        return repository;
    }
    public Appointment create(Appointment appointment) {
        appointmentTable.put(appointment.getId(),appointment);
        Appointment addAppointment = appointmentTable.get(appointment.getId());
        return addAppointment;
    }

    public Appointment read(String id) {
        Appointment appointment = appointmentTable.get(id);
        return appointment;
    }

	
    public Appointment update(Appointment appointment) {
        appointmentTable.put(appointment.getId(),appointment);
        Appointment updateAppointment = appointmentTable.get(appointment.getId());
        return updateAppointment;
    }

    public void delete(String id) {
        appointmentTable.remove(id);
    }
}
*/