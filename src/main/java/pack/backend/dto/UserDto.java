package pack.backend.dto;

import pack.backend.entity.user.enumeration.UserRoleEnum;

public record UserDto(
        String username,
        String email,
        UserRoleEnum role
) {}
