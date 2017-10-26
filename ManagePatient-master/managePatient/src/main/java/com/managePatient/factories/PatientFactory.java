package com.managePatient.factories;


import com.managePatient.domain.Patient;

/**
 * Created by tmoshasha on 2017/08/13.
 */
public class PatientFactory {
    public static Patient buildPatient(String name, String surname, String address, String cellNumber,String condition,
    String attandanceType){
        Patient patient = new Patient.Builder()
                .name(name)
                .surname(surname)
                .address(address)
                .cellNumber(cellNumber)
                .condition(condition)
                .attendanceType(attandanceType)
                .build();
        return  patient;
    }
}
