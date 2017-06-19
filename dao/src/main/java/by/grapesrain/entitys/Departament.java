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
@Table(name = "departament")
@ToString
@NoArgsConstructor
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "departament")
    private Set<User> users = new HashSet<User>();
}
