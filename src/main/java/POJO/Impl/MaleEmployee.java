package POJO.Impl;

import POJO.Inter.Employee;

import java.io.Serializable;

public class MaleEmployee extends Employee implements Serializable {

    private MaleHealthForm maleHealthForm = null;

    public MaleHealthForm getMaleHealthForm() {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
        this.maleHealthForm = maleHealthForm;
    }

    @Override
    public String toString() {
        return "MaleEmployee{" +super.toString()+
                "maleHealthForm=" + maleHealthForm +
                '}';
    }
}
