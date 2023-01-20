package pack.backend.service.employee;

import pack.backend.entity.employee.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity createEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployee();
}
