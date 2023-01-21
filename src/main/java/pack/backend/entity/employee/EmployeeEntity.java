package pack.backend.entity.employee;

import jakarta.persistence.*;
import lombok.*;
import pack.backend.entity.employee.enumeration.EmployeeGenderEnum;
import pack.backend.entity.employee.enumeration.EmployeeJobRoleEnum;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private EmployeeGenderEnum gender;

    @Enumerated(EnumType.STRING)
    private EmployeeJobRoleEnum jobRole;

    @Temporal(TemporalType.DATE)
    private Date date_join = new Date(System.currentTimeMillis());
}
