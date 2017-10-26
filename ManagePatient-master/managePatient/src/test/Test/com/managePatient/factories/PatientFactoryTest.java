package com.managePatient.factories;


import com.managePatient.domain.Patient;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by tmoshasha on 2017/08/13.
 */
public class PatientFactoryTest {

    private static String  id = "12";
    private static String  name = "Zimasa";
    private static String  surname = "Bhaduza";
    private static String  address = "N03 Umhlonto Drive Joe Slovo Park";
    private static String  cellNumber = "0794339330";
    private static String  condition = "Critical";
    private static String  attandenceType  = "first time";

    @BeforeClass
    public static void setUp() throws Exception {
        Patient values = new Patient(id,name,surname,address,cellNumber,condition,attandenceType);
    }
    @Test
    public void getPatient() throws Exception {
        Patient patient = PatientFactory.buildPatient(name,surname,address,cellNumber,condition,attandenceType);
        assertEquals("0794339330",patient.getCellNumber());
    }
}
