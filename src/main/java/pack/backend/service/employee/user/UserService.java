package pack.backend.service.employee.user;

import pack.backend.dto.ResponseUserDataDTO;

import java.util.List;

public interface UserService {
    List<ResponseUserDataDTO> getAllUser();
    String deleteUserById(Integer id);
}
