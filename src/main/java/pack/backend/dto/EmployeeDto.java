package pack.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pack.backend.entity.employee.enumeration.EmployeeGenderEnum;
import pack.backend.entity.employee.enumeration.EmployeeJobRoleEnum;

@Getter
@Setter
public class EmployeeDto {

    @NotEmpty(message = "First name is required.")
    private String firstName;

    private String lastName;

    @Email(message = "Email pattern doesn't valid.")
    private String email;

    @NotNull(message = "Gender is required.")
    private EmployeeGenderEnum gender;

    @NotNull(message = "Job role is very important.")
    private EmployeeJobRoleEnum jobRole;
}
