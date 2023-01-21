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

    @NotEmpty(message = "Name is required.")
    private String name;

    @Email(message = "Email pattern doesn't valid.")
    private String email;

    @NotNull(message = "Gender is required.")
    private EmployeeGenderEnum gender;

    @NotNull(message = "Job role is very important.")
    private EmployeeJobRoleEnum jobRole;
}
