package pack.backend.entity.user;

import jakarta.persistence.*;

@Entity
@Table(name = "User_Account")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
}
