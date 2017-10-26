package com.managePatient.controllers;


import com.managePatient.domain.Treatment;
import com.managePatient.services.treatment.TreatmentService;
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

public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    /*
        Make An Treatment
     */
    @RequestMapping(value="/makeTreatment/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Treatment> makeTreatment(@RequestBody Treatment treatment)
    {
        treatmentService.save(treatment);
        return new ResponseEntity<Treatment>(treatment, HttpStatus.CREATED);
    }



    /*
       Get a single Treatment based on a given id
    * */
    @RequestMapping(value = "/findTreatment/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Treatment> findTreatmentByID(@PathVariable("id") String id) {
        Treatment treatment = treatmentService.findById(id);
        if (treatment == null) {
            return new ResponseEntity<Treatment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Treatment>(treatment, HttpStatus.OK);
    }


    /*
        Get All Treatment
      */
    @RequestMapping(value = "/myTreatments/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Treatment>> findAllTreatment() {
        Iterable<Treatment> appointment = treatmentService.readAll();
        if (appointment == null) {
            return new ResponseEntity<Iterable<Treatment>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Treatment>>(appointment, HttpStatus.OK);
    }


    /*
        Cancel Treatment for a given ID
    * */
    @RequestMapping(value = "/cancelTreatment/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Treatment> cancelTreatment(@PathVariable("id") String id)
    {
        Treatment treatment = treatmentService.findById(id);
        if(treatment == null)
        {
            return new ResponseEntity<Treatment>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        treatmentService.delete(treatment);
        return new ResponseEntity<Treatment>(HttpStatus.NO_CONTENT);
    }

}
