package com.managePatient.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by tmoshasha on 2017/08/08.
 */
@Entity
@Table(name = "Treatment")
public class Treatment {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String treatmentName;
    private String description;
    private String dosage;

    public Treatment(String id, String treatmentName, String description, String dosage) {
        this.id = id;
        this.treatmentName = treatmentName;
        this.description = description;
        this.dosage = dosage;
    }

    public String getId() {return id;}

    public String getTreatmentName() {return treatmentName;}

    public String getDescription() {return description;}

    public String getDosage() {return dosage;}

    public Treatment(Builder builder){
        this.id = builder.id;
        this.treatmentName = builder.treatmentName;
        this.description = builder.description;
        this.dosage = builder.dosage;
    }

    public static class Builder{
        private String id;
        private String treatmentName;
        private String description;
        private String dosage;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder treatmentName(String value){
            this.treatmentName = value;
            return this;
        }

        public Builder description(String value){
            this.description = value;
            return this;
        }

        public Builder dosage(String value){
            this.dosage = value;
            return this;
        }

        public Builder copyTreatment(Treatment value){
            this.id = value.id;
            this.treatmentName = value.treatmentName;
            this.description = value.description;
            this.dosage = value.dosage;
            return this;
        }

        public Treatment build(){
            return new Treatment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Treatment treatment = (Treatment) o;

        return !(id != null ? !id.equals(treatment.id) : treatment.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
