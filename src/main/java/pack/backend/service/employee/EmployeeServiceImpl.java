package pack.backend.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return repository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return repository.findAll();
    }
}
