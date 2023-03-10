package pack.backend.employeeControllerTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pack.backend.entity.employee.EmployeeEntity;
import pack.backend.entity.employee.enumeration.EmployeeGenderEnum;
import pack.backend.entity.employee.enumeration.EmployeeJobRoleEnum;
import pack.backend.service.employee.EmployeeServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class EmployeeTestApi {

    @Mock
    EmployeeServiceImpl employeeService = mock(EmployeeServiceImpl.class);

    @Test
    void isValidationForEmployeeClassTrue() {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(1);
        entity.setName("Haru Kazumoto");
        entity.setEmail("HaruKazumoto@gmail.com");
        entity.setGender(EmployeeGenderEnum.MALE);
        entity.setJobRole(EmployeeJobRoleEnum.BACKEND);

        assertThat(employeeService.createNewEmployee(entity));
//        assertEquals(HttpStatus.valueOf(200), employeeService.createEmployee(entity));
    }
}
