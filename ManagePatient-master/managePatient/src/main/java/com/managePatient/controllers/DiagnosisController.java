package com.managePatient.controllers;

import com.managePatient.domain.Diagnosis;
import com.managePatient.services.diagnosis.DiagnosisService;
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

public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisServiceService;


    /*
        Make An Diagnosis
     */

    @RequestMapping(value="/makeDiagnosis/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Diagnosis> makeDiagnosis(@RequestBody Diagnosis makeDiagnosis)
    {
        diagnosisServiceService.save(makeDiagnosis);
        return new ResponseEntity<Diagnosis>(makeDiagnosis, HttpStatus.CREATED);
    }

    /*
       Get a single Diagnosis based on a given id
    * */
    @RequestMapping(value = "/findDiagnosis/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Diagnosis> findAppointmentByID(@PathVariable("id") String id) {
        Diagnosis diagnosis = diagnosisServiceService.findById(id);
        if (diagnosis == null) {
            return new ResponseEntity<Diagnosis>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Diagnosis>(diagnosis, HttpStatus.OK);
    }

    /*
        Get All Diagnosis
      */
    @RequestMapping(value = "/myDiagnosis/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Diagnosis>> findAllDiagnosis() {
        Iterable<Diagnosis> diagnosis = diagnosisServiceService.readAll();
        if (diagnosis == null) {
            return new ResponseEntity<Iterable<Diagnosis>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Diagnosis>>(diagnosis, HttpStatus.OK);
    }

    /*
        UPDATE Diagnosis for a given id
    * */
    @RequestMapping(value = "/changeDiagnosis/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Diagnosis> changeDiagnosis(@PathVariable("id") String id, @RequestBody Diagnosis diagnosis)
    {
        Diagnosis toUpdate = diagnosisServiceService.findById(id);
        if(diagnosis == null)
        {
            return new ResponseEntity<Diagnosis>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Diagnosis update = new Diagnosis.Builder()
                .copyDiagnosis(toUpdate)
                .name(diagnosis.getName())
                .description(diagnosis.getDescription())
                .build();
        diagnosisServiceService.update(update);
        return new ResponseEntity<Diagnosis>(update,HttpStatus.OK);
    }

    /*
        Cancel Diagnosis for a given ID
    * */
    @RequestMapping(value = "/cancelDiagnosis/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Diagnosis> cancelDiagnosis(@PathVariable("id") String id)
    {
        Diagnosis diagnosis = diagnosisServiceService.findById(id);
        if(diagnosis == null)
        {
            return new ResponseEntity<Diagnosis>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        diagnosisServiceService.delete(diagnosis);
        return new ResponseEntity<Diagnosis>(HttpStatus.NO_CONTENT);
    }
}
