package com.managePatient.repositories;

import java.util.Map;
/**
 * Created by tmoshasha on 2017/08/13.
 */
public class DoctorRepositoryTest {

    Map<String,String> values;
    DoctorRepository repository;
/**
    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","12");
        values.put("name","Teboho");
        values.put("surname","Moshasha");
        values.put("address","37 Boetsap Street Delft");
        values.put("cellNumber","0749718342");
        values.put("speciality","Dentist");
        values.put("qualification","MBH in Medicne");
    }

    @Test
    public void create() throws Exception {
        Doctor doctor = DoctorFactory.getDoctor(values, "12");
        repository.save(doctor);
        assertEquals("Teboho",doctor.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Doctor readDoctor = repository.findOne("12");
        assertEquals("Teboho",readDoctor.getName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Doctor readDoctor = repository.findOne("12");
        Doctor newDoctor = new Doctor.Builder()
                .name(values.get("Teboho"))
                .surname(values.get("Dingile"))
                .address(values.get("37 Boetsap Street Delft"))
                .cellNumber(values.get("0749718342"))
                .speciality(values.get("Dentist"))
                .qualification(values.get("MBH in Medicne"))
                .build();
        repository.findOne("");
        Doctor updatedDoctor = repository.findOne("12");
        assertEquals("2017-09-09", updatedDoctor.getName());
    }


    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("12");
        Doctor doctor = repository.findOne("12");
        assertNull(doctor);
    }
*/
}
