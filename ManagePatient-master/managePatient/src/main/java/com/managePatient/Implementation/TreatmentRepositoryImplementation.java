package com.managePatient.Implementation;

/**
 * Created by tmoshasha on 2017/08/13.
 */

public class TreatmentRepositoryImplementation{}

/**
public class TreatmentRepositoryImplementation implements TreatmentRepository {


    private  static TreatmentRepositoryImplementation repository = null;
    private Map<String, Treatment> treatmentTable;
    private TreatmentRepositoryImplementation(){treatmentTable = new HashMap<String, Treatment>();}

    public static TreatmentRepositoryImplementation getInstance(){
        if(repository ==null)
            repository = new TreatmentRepositoryImplementation();
        return repository;
    }

    public Treatment create(Treatment treatment) {
        treatmentTable.put(treatment.getId(),treatment);
        Treatment addTreatment = treatmentTable.get(treatment.getId());
        return addTreatment;
    }

    public Treatment read(String id) {
        Treatment treatment = treatmentTable.get(id);
        return treatment;
    }

    public Treatment update(Treatment treatment) {
        treatmentTable.put(treatment.getId(),treatment);
        Treatment updateTreatment = treatmentTable.get(treatment.getId());
        return updateTreatment;
    }

    public void delete(String id) {
        treatmentTable.remove(id);
    }
}
*/