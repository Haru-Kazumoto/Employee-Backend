package pack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.entity.employee.enumeration.EmployeeJobRoleEnum;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    Optional<EmployeeEntity> findByEmail(String email);
    List<EmployeeEntity> findByJobRole(EmployeeJobRoleEnum jobRole);
}
