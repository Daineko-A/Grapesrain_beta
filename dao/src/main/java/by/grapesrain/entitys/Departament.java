package by.grapesrain.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daynekoa on 28.05.2017.
 */
@Entity
@Table(name = "departament")
@ToString(callSuper = true, exclude = "users")
@NoArgsConstructor
public class Departament extends BaseEntity {

    public Departament(String name) {
        this.name = name;
    }

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "departament")
    private Set<User> users = new HashSet<User>();
}
