package com.managePatient.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tmoshasha on 2017/08/08.
 */

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable,Comparable<Appointment>{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String appointmentDate;

    public String getId() {
        return id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public Appointment(String id, String appointmentDate) {
        this.id = id;
        this.appointmentDate = appointmentDate;
    }

    public Appointment(Builder builder){
        this.id = builder.id;
        this.appointmentDate = builder.appointmentDate;
    }

    @Override
    public int compareTo(Appointment appo) {
        return id.compareTo(appo.id);
    }

    public static class Builder{
        private String id;
        private String appointmentDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder appointmentDate(String value){
            this.appointmentDate = value;
            return this;
        }

        public Builder copyAppointment(Appointment value)
        {
            this.id = value.id;
            this.appointmentDate = value.appointmentDate;
            return this;
        }

        public Appointment build(){
            return new Appointment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
