package by.grapesrain.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Daynekoa on 27.05.2017.
 */
@Entity
@Table(name = "user")
@ToString
@NoArgsConstructor
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Column(name = "phone_number")
    private long phoneNumber;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament departament;
}
