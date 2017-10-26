package com.managePatient.repositories;

import com.managePatient.domain.Treatment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tmoshasha on 2017/08/13.
 */

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, String>{}
