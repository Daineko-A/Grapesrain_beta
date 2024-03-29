package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daynekoa on 28.05.2017.
 */

@Entity
@Table(name = "role")
@ToString(callSuper = true, exclude = "users")
@NoArgsConstructor
public class Role extends BaseEntity {

    public Role(String role) {
        this.role = role;
    }

    @Getter
    @Setter
    @Column(name = "role")
    private String role;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

//    @Getter
//    @Setter
//    @OneToMany(mappedBy = "userRole")
//    private Set<User> users = new HashSet<User>();
}