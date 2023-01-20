package pack.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pack.backend.entity.user.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
