package com.managePatient.controllers;


import com.managePatient.domain.Appointment;
import com.managePatient.services.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tmoshasha on 2017/08/08.
 */

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    /*
        Make An Appointment
     */

    @RequestMapping(value="/makeAppointment/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)

    public ResponseEntity<Appointment> makeAppointment(@RequestBody Appointment appointment)
    {
        appointmentService.save(appointment);
        return new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
    }

    /*
       Get a single Appointment based on a given id
    * */
    @RequestMapping(value = "/findAppointment/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Appointment> findAppointmentByID(@PathVariable("id") String id) {
        Appointment appointment = appointmentService.findById(id);
        if (appointment == null) {
            return new ResponseEntity<Appointment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
    }

    /*
        Get All Appointments
      */
    @RequestMapping(value = "/myAppointments/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Appointment>> findAllAppointments() {
        Iterable<Appointment> appointment = appointmentService.readAll();
        if (appointment == null) {
            return new ResponseEntity<Iterable<Appointment>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Appointment>>(appointment, HttpStatus.OK);
    }


    /*
        UPDATE Appointment for a given id
    * */
     @RequestMapping(value = "/changeAppointments/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") String id, @RequestBody Appointment appointment)
    {
        Appointment toUpdate = appointmentService.findById(id);
        if(appointment == null)
        {
            return new ResponseEntity<Appointment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Appointment update = new Appointment.Builder()
                .copyAppointment(toUpdate)
                .appointmentDate(appointment.getAppointmentDate())
                .build();
        appointmentService.update(update);
        return new ResponseEntity<Appointment>(update,HttpStatus.OK);
    }

    /*
        Cancel Appointment for a given ID
    * */
     @RequestMapping(value = "/cancelAppointment/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable("id") String id)
    {
        Appointment appointment = appointmentService.findById(id);
        if(appointment == null)
        {
            return new ResponseEntity<Appointment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        appointmentService.delete(appointment);
        return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
    }


}