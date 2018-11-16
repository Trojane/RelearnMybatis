package POJO.Impl;

import POJO.Inter.HealthForm;

import java.io.Serializable;

public class MaleHealthForm extends HealthForm implements Serializable {

    private String prostate;

    public String getProstate() {
        return prostate;
    }

    public void setProstate(String prostate) {
        this.prostate = prostate;
    }

    @Override
    public String toString() {
        return "MaleHealthForm{" +super.toString()+
                "prostate='" + prostate + '\'' +
                '}';
    }
}
