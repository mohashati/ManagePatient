package com.managePatient.repositories;

import java.util.Map;

/**
 * Created by tmoshasha on 2017/08/13.
 */
public class DiagnosisRepositoryTest {
    Map<String,String> values;
    DiagnosisRepository repository;
/**
    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","12");
        values.put("name","Headache");
        values.put("description","sharp pain in the forehead");
        values.put("dosage","Take take 3 tablets 3 times a day");
    }
    @Test
    public void getDiagnosis() throws Exception {
        Diagnosis diagnosis = DiagnosisFactory.getDiagnosis(values,"12");
        repository.save(diagnosis);
        assertEquals("Headache",diagnosis.getName());
    }

    @Test
    public void create() throws Exception {
        Diagnosis diagnosis = DiagnosisFactory.getDiagnosis(values,"12");
        repository.save(diagnosis);
        assertEquals("2017-08-14",diagnosis.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Diagnosis readDiagnosis = repository.findOne("12");
        assertEquals("2017-08-14",readDiagnosis.getName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Diagnosis readAppointment = repository.findOne("12");
        Diagnosis newDiagnosis = new Diagnosis.Builder()
                .name(values.get("name"))
                .description(values.get("description"))
                .build();
        repository.findOne("");
        Diagnosis updatedDiagnosis = repository.findOne("12");
        assertEquals("Headache", updatedDiagnosis.getName());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("12");
        Diagnosis diagnosis = repository.findOne("12");
        assertNull(diagnosis);
    }
    */
}
