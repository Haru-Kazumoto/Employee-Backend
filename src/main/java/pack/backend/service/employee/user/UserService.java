package pack.backend.service.employee.user;

import pack.backend.dto.user.dto.ResponseUserDataDTO;
import pack.backend.entity.user.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<ResponseUserDataDTO> getAllUser();
    String deleteUserById(Integer id);
}
