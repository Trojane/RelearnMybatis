package Mapper;

import POJO.Impl.EmployeeTask;

import java.util.List;

public interface EmployeeTaskMapper {

    public List<EmployeeTask> getEmployeeTaskByEmpId(Long empId);

}
