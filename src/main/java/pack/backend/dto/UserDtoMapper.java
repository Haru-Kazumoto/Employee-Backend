package pack.backend.dto;

import org.springframework.stereotype.Service;
import pack.backend.entity.user.UserEntity;

import java.util.function.Function;

@Service
public class UserDtoMapper implements Function<UserEntity, ResponseUserDataDTO> {
    @Override
    public ResponseUserDataDTO apply(UserEntity user) {
        return new ResponseUserDataDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}
