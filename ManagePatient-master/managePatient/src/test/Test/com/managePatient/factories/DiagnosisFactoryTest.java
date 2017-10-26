package com.managePatient.factories;

import com.managePatient.domain.Diagnosis;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by tmoshasha on 2017/08/13.
 */
public class DiagnosisFactoryTest {

    private static String id = "88888888";
    private static String name= "Panado";
    private static String description = "shar pain in the forehead";

    @BeforeClass
    public static void setUp() throws Exception {
        Diagnosis values = new Diagnosis(id,name,description);

    }
    @Test
    public void getDiagnosis() throws Exception {
        Diagnosis diagnosis = DiagnosisFactory.buildDiagnosis(name,description);
        assertEquals("shar pain in the forehead",diagnosis.getDescription());
    }
}
