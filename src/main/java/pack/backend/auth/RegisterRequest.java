package pack.backend.auth;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.backend.entity.user.enumeration.UserRoleEnum;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotNull(message = "Username is required")
    private String username;

    @NotNull(message = "Email is required")
    @Email(message = "Email pattern doesn't valid.")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotEmpty(message = "Job role is required")
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;
}
