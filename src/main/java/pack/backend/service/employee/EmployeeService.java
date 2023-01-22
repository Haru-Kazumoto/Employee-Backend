package pack.backend.service.employee;

import pack.backend.entity.employee.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity createNewEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployee();

    //TODO : find by email employee and employee name.
}
