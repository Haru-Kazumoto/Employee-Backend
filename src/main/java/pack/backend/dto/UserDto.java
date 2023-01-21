package pack.backend.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pack.backend.entity.user.enumeration.UserRoleEnum;

@Getter @Setter
public class UserDto {

    @Email(message = "Email pattern doesn't valid.")
    @NotEmpty(message = "Email field is required.")
    private String email;

    @NotEmpty(message = "Password cant be empty")
    private String password;

    @NotNull(message = "Role user is very important.")
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;
}
