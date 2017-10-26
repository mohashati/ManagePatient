package com.managePatient.factories;

import com.managePatient.domain.Doctor;

/**
 * Created by tmoshasha on 2017/08/10.
 */
public class DoctorFactory {
    public static Doctor buildDoctor(String name, String surname, String address, String cellNumber,String speciality, String qualification){
        Doctor doctor = new Doctor.Builder()
                .name(name)
                .surname(surname)
                .address(address)
                .cellNumber(cellNumber)
                .speciality(speciality)
                .qualification(qualification)
                .build();
                return doctor;
    }
}
