package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daynekoa on 28.05.2017.
 */

@Entity
@Table(name = "user_role")
@ToString(callSuper = true, exclude = "users")
@NoArgsConstructor
public class UserRole extends BaseEntity {

    public UserRole(String role) {
        this.role = role;
    }

    @Getter
    @Setter
    @Column(name = "role")
    protected String role;

    @OneToMany(mappedBy = "userRole")
    @Getter
    @Setter
    private Set<User> users = new HashSet<User>();

}
