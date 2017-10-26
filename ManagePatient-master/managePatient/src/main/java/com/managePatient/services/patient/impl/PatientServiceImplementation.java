package com.managePatient.services.patient.impl;

import com.managePatient.domain.Patient;
import com.managePatient.repositories.PatientRepository;
import com.managePatient.services.patient.PatientService;
import org.springframework.stereotype.Service;


/**
 * Created by tmoshasha on 2017/08/13.
 */

@Service
public class PatientServiceImplementation implements PatientService{

    //@Autowired
    private PatientRepository patientRepository;

	@Override
    public Patient save(Patient patient) {return patientRepository.save(patient);}

    @Override
    public Patient findById(String id) {return patientRepository.findOne(id);}

    @Override
    public Patient update(Patient entity) {
        return patientRepository.save(entity);
    }

    @Override
    public void delete(Patient entity) {
        patientRepository.delete(entity);
    }

    @Override
    public Iterable<Patient> readAll() {
        Iterable<Patient> result = patientRepository.findAll();
        return result;
    }

}
