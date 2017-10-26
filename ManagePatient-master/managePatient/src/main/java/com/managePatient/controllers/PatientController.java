package com.managePatient.controllers;

import com.managePatient.domain.Patient;
import com.managePatient.services.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tmoshasha on 2017/08/08.
 */

public class PatientController {

    @Autowired
    private PatientService patientService;

    /*
        Make An Patient
     */

    @RequestMapping(value="/makePatient/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient)
    {
        patientService.save(patient);
        return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
    }

    /*
        Get a single Patient based on a given id
    * */
    @RequestMapping(value = "/findPatient/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Patient> findPatientByID(@PathVariable("id") String id) {
        Patient patient = patientService.findById(id);
        if (patient == null) {
            return new ResponseEntity<Patient>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

    /*
        Get All Patient
      */
    @RequestMapping(value = "/myPatients/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Patient>> findAllPatients() {
        Iterable<Patient> patient = patientService.readAll();
        if (patient == null) {
            return new ResponseEntity<Iterable<Patient>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Patient>>(patient, HttpStatus.OK);
    }

    /*
       UPDATE Patient for a given id
   * */
    @RequestMapping(value = "/changePatient/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") String id, @RequestBody Patient patient)
    {
        Patient toUpdate = patientService.findById(id);
        if(patient == null)
        {
            return new ResponseEntity<Patient>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Patient update = new Patient.Builder()
                .copyPatient(toUpdate)
                .name(patient.getName())
                .surname(patient.getSurname())
                .address(patient.getAddress())
                .cellNumber(patient.getCellNumber())
                .condition(patient.getCondition())
                .attendanceType(patient.getAttendanceType())
                .build();
        patientService.update(update);
        return new ResponseEntity<Patient>(update,HttpStatus.OK);
    }

    /*
        Cancel Patient for a given ID
    * */
    @RequestMapping(value = "/cancelAppointment/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") String id)
    {
        Patient patient = patientService.findById(id);
        if(patient == null)
        {
            return new ResponseEntity<Patient>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        patientService.delete(patient);
        return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
    }

}
