package com.managePatient.services.treatment.impl;

import com.managePatient.domain.Treatment;
import com.managePatient.repositories.TreatmentRepository;
import com.managePatient.services.treatment.TreatmentService;
import org.springframework.stereotype.Service;


/**
 * Created by tmoshasha on 2017/08/13.
 */

@Service
public class TreatmentServiceImplementation implements TreatmentService{

    //@Autowired
	private TreatmentRepository treatmentRepository;

    @Override
    public Treatment save(Treatment treatment) {return treatmentRepository.save(treatment);}

    @Override
    public Treatment update(Treatment treatment) {return treatmentRepository.save(treatment);}

    @Override
    public void delete(Treatment entity) {
        treatmentRepository.save(entity);
    }

    @Override
    public Iterable<Treatment> readAll() {
        Iterable<Treatment> result = treatmentRepository.findAll();
        return result;
    }

    @Override
    public Treatment findById(String id) {
        return treatmentRepository.findOne(id);
    }
}
