package com.managePatient.factories;


        import com.managePatient.domain.Diagnosis;

/**
 * Created by tmoshasha on 2017/08/11.
 */
public class DiagnosisFactory {
    public static Diagnosis buildDiagnosis(String name, String description){
        Diagnosis diagnosis = new Diagnosis.Builder()
                .description(description)
                .build();
        return diagnosis;
    }
}
