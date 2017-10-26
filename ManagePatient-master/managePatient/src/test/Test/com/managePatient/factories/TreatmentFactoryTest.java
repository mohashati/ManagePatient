package com.managePatient.factories;


import com.managePatient.domain.Treatment;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tmoshasha on 2017/08/13.
 */
public class TreatmentFactoryTest {

    private static String  id = "54544545";
    private static String name = "Panado";
    private static String desc = "Heals headache and fever";
    private static String dosage = "Take 3 tablets a day, after meals";

    @BeforeClass
    public static void setUp() throws Exception {

        Treatment values = new Treatment(id, name,desc,dosage);
    }
    @Test
    public void getTreatment() throws Exception {
        Treatment treatment = TreatmentFactory.buildTreatment(name,desc,dosage);
        assertEquals("Take 3 tablets a day, after meals",treatment.getDosage());
    }
}
