package pack.backend.auth;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.backend.entity.user.enumeration.UserRoleEnum;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;
}
