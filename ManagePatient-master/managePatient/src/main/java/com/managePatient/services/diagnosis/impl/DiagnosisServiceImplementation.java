package com.managePatient.services.diagnosis.impl;

import com.managePatient.domain.Diagnosis;
import com.managePatient.repositories.DiagnosisRepository;
import com.managePatient.services.diagnosis.DiagnosisService;
import org.springframework.stereotype.Service;

/**
 * Created by tmoshasha on 2017/08/13.
 */

@Service
public class DiagnosisServiceImplementation implements DiagnosisService{

	//@Autowired
    private  DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis save(Diagnosis diagnosis) {return diagnosisRepository.save(diagnosis);}

    @Override
    public Diagnosis findById(String s) {return diagnosisRepository.findOne(s); }

    @Override
    public Diagnosis update(Diagnosis entity) {
        return diagnosisRepository.save(entity);
    }

    @Override
    public void delete(Diagnosis entity) {
        diagnosisRepository.delete(entity);
    }

    @Override
    public Iterable<Diagnosis> readAll() {
        Iterable<Diagnosis> result = diagnosisRepository.findAll();
        return result;
    }
}
