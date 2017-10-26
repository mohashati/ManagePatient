package com.managePatient.repositories;

import com.managePatient.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tmoshasha on 2017/08/13.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, String>{}
