package com.managePatient.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by tmoshasha on 2017/08/08.
 */
@Entity
@Table(name = "Patient")
public class Patient{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String surname;
    private String address;
    private String cellNumber;
    private String condition;
    private String attendanceType;

    public Patient(String id, String name, String surname, String address, String cellNumber, String condition, String attendanceType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.cellNumber = cellNumber;
        this.condition = condition;
        this.attendanceType = attendanceType;
    }

    public String getId() {return id;}

    public String getName() {return name;}

    public String getSurname() {return surname;}

    public String getAddress() {return address;}

    public String getCellNumber() {return cellNumber;}

    public String getCondition() {
        return condition;
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                ", condition='" + condition + '\'' +
                ", attendanceType='" + attendanceType + '\'' +
                '}';
    }

    public Patient(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
        this.cellNumber = builder.cellNumber;
        this.condition = builder.condition;
        this.attendanceType = builder.attendanceType;
    }

    public static class Builder{
        private String id;
        private String name;
        private String surname;
        private String address;
        private String cellNumber;
        private String condition;
        private String attendanceType;


        public Builder id(String value) {
            this.id = value;
            return this;
        }


        public Builder name(String value) {
            this.name = value;
            return this;
        }


        public Builder surname(String value) {
            this.surname = value;
            return this;
        }
        public Builder address(String value) {
            this.address = value;
            return this;
        }
        public Builder cellNumber(String value) {
            this.cellNumber = value;
            return this;

        }

        public Builder condition(String value) {
            this.condition = value;
            return this;
        }

        public Builder attendanceType(String value) {
            this.attendanceType = value;
            return this;
        }

        public Builder copyPatient (Patient value) {
            this.id = value.id;
            this.name = value.name;
            this.surname = value.surname;
            this.address = value.address;
            this.cellNumber = value.cellNumber;
            this.condition = value.condition;
            this.attendanceType = value.attendanceType;

            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        return !(id != null ? !id.equals(patient.id) : patient.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
