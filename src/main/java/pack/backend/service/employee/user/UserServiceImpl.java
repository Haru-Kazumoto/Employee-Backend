package pack.backend.service.employee.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.backend.dto.ResponseUserDataDTO;
import pack.backend.dto.UserDtoMapper;
import pack.backend.entity.user.UserEntity;
import pack.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserDtoMapper userDtoMapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserDtoMapper userDtoMapper) {
        this.repository = repository;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public List<ResponseUserDataDTO> getAllUser() {
        return repository.findAll()
                .stream()
                .map(userDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteUserById(Integer id) {
        Optional<UserEntity> idUser = repository.findById(id);
        if(idUser.isEmpty()){
            return String.format("Failed to delete [Id %d not found.]", id);
        }
        repository.deleteById(id);
        return String.format("Success delete [Id %d has deleted]", id);
    }
}
