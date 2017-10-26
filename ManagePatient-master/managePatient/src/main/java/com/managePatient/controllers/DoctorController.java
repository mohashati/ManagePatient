package com.managePatient.controllers;

import com.managePatient.domain.Doctor;
import com.managePatient.services.doctor.DoctorService;
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

public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /*
        Make An Doctor
     */

    @RequestMapping(value="/addDoctor/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor)
    {
        doctorService.save(doctor);
        return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
    }

    /*
       Get a single Appointment based on a given id
    * */
    @RequestMapping(value = "/findDoctor/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Doctor> findDoctorByID(@PathVariable("id") String id) {
        Doctor doctor = doctorService.findById(id);
        if (doctor == null) {
            return new ResponseEntity<Doctor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
    }

    /*
        UPDATE Doctor for a given id
    * */
    @RequestMapping(value = "/updateDoctor/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") String id, @RequestBody Doctor doctor)
    {
        Doctor toUpdate = doctorService.findById(id);
        if(doctor == null)
        {
            return new ResponseEntity<Doctor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Doctor update = new Doctor.Builder()
                .copyDoctor(toUpdate)
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .address(doctor.getAddress())
                .cellNumber(doctor.getCellNumber())
                .speciality(doctor.getSpeciality())
                .qualification(doctor.getQualification())
                .build();
        doctorService.update(update);
        return new ResponseEntity<Doctor>(update,HttpStatus.OK);
    }


    /*
        Get All Doctors
      */
    @RequestMapping(value = "/findAllDoctors/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Doctor>> findAllDoctors() {
        Iterable<Doctor> doctor = doctorService.readAll();
        if (doctor == null) {
            return new ResponseEntity<Iterable<Doctor>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Doctor>>(doctor, HttpStatus.OK);
    }

    /*
        Delete Doctor for a given ID
    * */
    @RequestMapping(value = "/deleteDoctor/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable("id") String id)
    {
        Doctor doctor = doctorService.findById(id);
        if(doctor == null)
        {
            return new ResponseEntity<Doctor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        doctorService.delete(doctor);
        return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
    }
}
