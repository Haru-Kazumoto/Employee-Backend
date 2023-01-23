package pack.backend.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.repository.EmployeeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeEntity createNewEmployee(EmployeeEntity employee) {
        return repository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findEmployeeByEmail(String email) {
        Optional<EmployeeEntity> emailEmployee = repository.findByEmail(email);
        if(emailEmployee.isEmpty() || emailEmployee.equals("")){
            throw new NoSuchElementException(String.format("%s not found", email));
        }
        return repository.findByEmail(email);
    }
}
