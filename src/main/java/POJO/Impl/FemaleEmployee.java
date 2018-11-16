package POJO.Impl;

import POJO.Inter.Employee;

import java.io.Serializable;

public class FemaleEmployee extends Employee implements Serializable {

    private FemaleHealthForm femaleHealthForm = null;

    public FemaleHealthForm getFemaleHealthForm() {
        return femaleHealthForm;
    }

    public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
        this.femaleHealthForm = femaleHealthForm;
    }

    @Override
    public String toString() {
        return "FemaleEmployee{" +super.toString()+
                "femaleHealthForm=" + femaleHealthForm +
                '}';
    }
}
