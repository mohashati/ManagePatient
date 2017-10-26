package com.managePatient.factories;

import com.managePatient.domain.Treatment;

/**
 * Created by tmoshasha on 2017/08/10.
 */
public class TreatmentFactory {
    public static Treatment buildTreatment(String treatmentName, String description, String dosage){
        Treatment treatment = new Treatment.Builder()
                .treatmentName(treatmentName)
                .description(description)
                .dosage(dosage)
                .build();
        return treatment;
    }
}
