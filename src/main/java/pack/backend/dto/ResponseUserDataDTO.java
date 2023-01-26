package pack.backend.dto;

import pack.backend.entity.user.enumeration.UserRoleEnum;

public record ResponseUserDataDTO(
        Integer id,
        String username,
        String email,
        UserRoleEnum role
) {
}