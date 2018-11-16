package POJO.Impl;

import POJO.Inter.HealthForm;

import java.io.Serializable;

public class FemaleHealthForm extends HealthForm implements Serializable {

    private String uterus;

    public String getUterus() {
        return uterus;
    }

    public void setUterus(String uterus) {
        this.uterus = uterus;
    }


    @Override
    public String toString() {
        return "FemaleHealthForm{" +super.toString()+
                "uterus='" + uterus + '\'' +
                '}';
    }
}
