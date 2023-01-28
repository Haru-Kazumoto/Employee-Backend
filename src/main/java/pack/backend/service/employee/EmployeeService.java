package pack.backend.service.employee;

import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.entity.employee.enumeration.EmployeeJobRoleEnum;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeEntity createNewEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployee();
    Optional<EmployeeEntity> findEmployeeByEmail(String email);
    List<EmployeeEntity> findEmployeeByRole(EmployeeJobRoleEnum role);
    EmployeeEntity updateEmployee(EmployeeEntity employee);
    void deleteEmployeeById(Integer id);

}
