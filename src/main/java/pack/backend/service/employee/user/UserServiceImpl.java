package pack.backend.service.employee.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.backend.dto.UserDto;
import pack.backend.entity.user.UserEntity;
import pack.backend.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<UserDto> getAllUser() {
        return null;
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
