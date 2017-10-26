package com.managePatient.repositories;

import java.util.Map;

/**
 * Created by tmoshasha on 2017/08/13.
 */
public class TreatmentRepositoryTest {
    TreatmentRepository repository;
    Map<String, String> values;
/**
    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id", "12");
        values.put("treatmentName", "Panado");
        values.put("description", "Heals headache and fever");
        values.put("dosage", "Take 3 tablets a day, after meals");
    }

    @Test
    public void create() throws Exception {
        Treatment treatment = TreatmentFactory.getTreatment(values, "12");
        repository.save(treatment);
        assertEquals("Teboho",treatment.getTreatmentName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Treatment readTreatment = repository.findOne("12");
        assertEquals("Panado",readTreatment.getTreatmentName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Treatment readTreatment = repository.findOne("12");
        Treatment newTreatment = new Treatment.Builder()
                .treatmentName(values.get( "Grandpa"))
                .description(values.get("Heals headache and fever"))
                .dosage(values.get("Take 3 tablets a day, after meals"))
                .build();
        repository.findOne("");
        Treatment updatedTreatment = repository.findOne("12");
        assertEquals("Grandpa", updatedTreatment.getTreatmentName());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("12");
        Treatment treatment = repository.findOne("12");
        assertNull(treatment);
    }
*/
}
