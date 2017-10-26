package com.managePatient.factories;

import com.managePatient.Key.Generator;
import com.managePatient.domain.Doctor;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by tmoshasha on 2017/08/13.
 */
public class DoctorFactoryTest {

    private static String  id = Generator.getEntityId();
    private static String name ="Teboho";
    private static String surname = "Moshasha";
    private static String  address = "37 Boetsap Street Delft";
    private static String  cellNumber = "0749718342";
    private static String speciality = "Dentist";
    private static String qualification = "MBH in Medicne";

    @BeforeClass
    public static void setUp() throws Exception {

        Doctor values = new Doctor(id,name,surname,address,cellNumber,speciality,qualification);
    }
    @Test
    public void getDoctor() throws Exception {
        Doctor doctor = DoctorFactory.buildDoctor(name,surname,address,cellNumber,speciality,qualification);
        assertEquals("Teboho",doctor.getName());
    }

}
