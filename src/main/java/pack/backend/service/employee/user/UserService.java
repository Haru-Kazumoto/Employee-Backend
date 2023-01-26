package pack.backend.service.employee.user;

import pack.backend.dto.UserDto;
import pack.backend.entity.user.UserEntity;

public interface UserService {
    Iterable<UserDto> getAllUser();
    String deleteUserById(Integer id);
}
