package POJO.Inter;

import POJO.Impl.EmployeeTask;
import POJO.Impl.WorkCard;
import POJO.Other.SexEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Employee implements Serializable {

    private Long id;
    private String realName;
    private SexEnum  sex;
    private Date birthday;
    private String mobile;
    private String email;
    private String position;
    private WorkCard workCard;
    private List<EmployeeTask> employeeTaskList = null;
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public WorkCard getWorkCard() {
        return workCard;
    }

    public void setWorkCard(WorkCard workCard) {
        this.workCard = workCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<EmployeeTask> getEmployeeTaskList() {
        return employeeTaskList;
    }

    public void setEmployeeTaskList(List<EmployeeTask> employeeTaskList) {
        this.employeeTaskList = employeeTaskList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", mobile='" + mobile + '\'' +
                ", position='" + position + '\'' +
                ", workCard=" + workCard +
                ", employeeTaskList=" + employeeTaskList +
                '}';
    }
}
