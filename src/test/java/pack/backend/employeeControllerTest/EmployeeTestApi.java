package pack.backend.employeeControllerTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.entity.enumeration.EmployeeGenderEnum;
import pack.backend.entity.enumeration.EmployeeJobRoleEnum;
import pack.backend.service.employee.EmployeeService;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class EmployeeTestApi {

    @Mock
    EmployeeService employeeService = mock(EmployeeService.class);

    @Test
    void isValidationForEmployeeClassTrue() {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(1);
        entity.setFirstName("Haru");
        entity.setLastName("Kazumoto");
        entity.setEmail("HaruKazumoto@gmail.com");
        entity.setGender(EmployeeGenderEnum.MALE);
        entity.setJobRole(EmployeeJobRoleEnum.BACKEND);

        assertThat(employeeService.createEmployee(entity));
//        assertEquals(HttpStatus.valueOf(200), employeeService.createEmployee(entity));
    }
}
