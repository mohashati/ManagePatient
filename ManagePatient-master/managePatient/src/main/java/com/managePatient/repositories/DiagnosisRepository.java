package com.managePatient.repositories;

import org.springframework.data.repository.CrudRepository;
import com.managePatient.domain.Diagnosis;

/**
 * Created by tmoshasha on 2017/08/13.
 */
public interface DiagnosisRepository extends CrudRepository<Diagnosis, String>{}

