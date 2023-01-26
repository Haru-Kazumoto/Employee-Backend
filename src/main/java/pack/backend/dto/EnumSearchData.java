package pack.backend.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import pack.backend.entity.employee.enumeration.EmployeeJobRoleEnum;

@Getter
@Setter
public class EnumSearchData {
    @Enumerated(EnumType.STRING)
    EmployeeJobRoleEnum roleEnum;
}
