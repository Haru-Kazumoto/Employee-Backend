package pack.backend.service.employee;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.repository.EmployeeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeEntity createNewEmployee(EmployeeEntity employee) {
        Optional<EmployeeEntity> isEmailExists = repository.findByEmail(employee.getEmail());
        if(isEmailExists.isPresent()){
            throw new IllegalArgumentException(String.format("Email %s already taken.", employee.getEmail()));
        }
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
            return Optional.empty();
        }
        return repository.findByEmail(email);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Optional<EmployeeEntity> dataId = repository.findById(id);
        if(dataId.isEmpty()){
            throw new NoSuchElementException(String.format("Id %d not found.", id));
        }
        repository.deleteById(id);
    }
}
