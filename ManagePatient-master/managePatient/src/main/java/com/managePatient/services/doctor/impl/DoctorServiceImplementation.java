package com.managePatient.services.doctor.impl;

import com.managePatient.domain.Doctor;
import com.managePatient.repositories.DoctorRepository;
import com.managePatient.services.doctor.DoctorService;
import org.springframework.stereotype.Service;

/**
 * Created by tmoshasha on 2017/08/13.
 */

@Service
public class DoctorServiceImplementation implements DoctorService {
	
	//@Autowired
    private  DoctorRepository doctorRepository;

	@Override
    public Doctor save(Doctor doctor) {return doctorRepository.save(doctor);}

    @Override
    public Doctor findById(String s) {
        return doctorRepository.findOne(s);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void delete(Doctor entity) {doctorRepository.delete(entity);}

    @Override
    public Iterable<Doctor> readAll() {
        Iterable<Doctor> result = doctorRepository.findAll();
        return result;
    }



}
